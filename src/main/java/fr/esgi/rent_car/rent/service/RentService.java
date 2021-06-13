package fr.esgi.rent_car.rent.service;


import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.service.CarService;
import fr.esgi.rent_car.rent.domain.model.RentDto;
import fr.esgi.rent_car.rent.domain.port.RentPersistencePort;
import fr.esgi.rent_car.rent.exception.RentException;
import fr.esgi.rent_car.rent.infra.RentConverter;
import fr.esgi.rent_car.rent.infra.web.model.RentCreationModel;
import fr.esgi.rent_car.user.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Period;

@Service
@AllArgsConstructor
public class RentService {
    private final RentPersistencePort rentPersistencePort;
    private final RentConverter rentConverter;
    private final SessionService sessionService;
    private final CarService carService;

    public RentDto save(RentCreationModel rentCreationModel) throws RentException {
        var carDto = recupererLaVoitureAvailableOK(rentCreationModel);

        if(Period.between(rentCreationModel.getStart_date(),rentCreationModel.getEnd_date()).getDays() <= 0)
            throw handleRentMassageDateException(rentCreationModel);

        var nbDays = Period.between(rentCreationModel.getStart_date(), rentCreationModel.getEnd_date()).getDays();

        var price = nbDays * carDto.getPrice_day();
        return checkRentedCarDate(rentCreationModel, nbDays, carDto, price);
    }

    private CarDto recupererLaVoitureAvailableOK(RentCreationModel rentCreationModel) {
        var carDto = carService.getCarById(rentCreationModel.getId_car());

        if (!Boolean.TRUE.equals(carDto.getAvailable())) {
            throw handleRentMassageCarException();
        }
        return carDto;
    }

    private RentDto checkRentedCarDate(RentCreationModel rentCreationModel, int nbDays, fr.esgi.rent_car.car.domain.model.CarDto carDto, double price) {
        if (Period.between(rentCreationModel.getStart_date(), carDto.getStart_date()).getDays() <= 0
                && Period.between(carDto.getEnd_date(), rentCreationModel.getEnd_date()).getDays() <= 0) {
            return rentCar(rentCreationModel, nbDays, carDto, price);
        } else {
            throw handleRentMassageException(rentCreationModel, carDto);
        }
    }

    private RentDto rentCar(RentCreationModel rentCreationModel, int nbDays, fr.esgi.rent_car.car.domain.model.CarDto carDto, double price) {
        setCarAvailableFalse(carDto);
        return rentConverter.convertRentToRentDto(
                rentPersistencePort.save(
                        rentConverter.convertCreationModelToRent(rentCreationModel, sessionService.getCurrentUser().getId(), price, nbDays)
                )
        );
    }

    private void setCarAvailableFalse(CarDto carDto) {
        carDto.setAvailable(false);
        carService.update(carDto);
    }

    private RentException handleRentMassageDateException(RentCreationModel rentCreationModel) {
        return new RentException(
                MessageFormat.format( "Pickup date : {0} must be the before the return date : {1}" ,
                        rentCreationModel.getStart_date(), rentCreationModel.getEnd_date()));
    }

    private RentException handleRentMassageCarException() {
        return new RentException("Car not available");
    }

    private RentException handleRentMassageException(RentCreationModel rentCreationModel, CarDto carDto) {
        return new RentException(Period.between(rentCreationModel.getStart_date(), carDto.getStart_date()).getDays() < 0 ?
                MessageFormat.format( "Pickup date : {0} must be the same or after the available start date : {1}" ,
                        rentCreationModel.getStart_date(), carDto.getStart_date()):
                MessageFormat.format( "Return date : {0} must be the same or before the available end date : {1}",
                        rentCreationModel.getEnd_date(), carDto.getEnd_date()));
    }


}
