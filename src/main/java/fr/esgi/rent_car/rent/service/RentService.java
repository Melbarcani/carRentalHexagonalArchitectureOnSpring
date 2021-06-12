package fr.esgi.rent_car.location.service;

import fr.esgi.rent_car.car.service.CarService;
import fr.esgi.rent_car.location.domain.model.Rent;
import fr.esgi.rent_car.location.domain.model.RentDto;
import fr.esgi.rent_car.location.domain.port.RentPersistencePort;
import fr.esgi.rent_car.location.exception.RentException;
import fr.esgi.rent_car.location.infra.RentConverter;
import fr.esgi.rent_car.location.infra.web.model.RentCreationModel;
import fr.esgi.rent_car.user.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
@AllArgsConstructor
public class RentService {
    private final RentPersistencePort rentPersistencePort;
    private final RentConverter rentConverter;
    private final SessionService sessionService;
    private final CarService carService;

    public RentDto save(RentCreationModel rentCreationModel) throws RentException {
        var nbDays = Period.between(rentCreationModel.getStart_date(),rentCreationModel.getEnd_date()).getDays();
        var carDto = carService.getCarById(rentCreationModel.getId_car());
        var price = nbDays * carDto.getPrice_day();
        if(Period.between(rentCreationModel.getStart_date(), carDto.getStart_date()).getDays() <= 0 && Period.between(carDto.getEnd_date(),rentCreationModel.getEnd_date()).getDays()  <= 0)
        {
            carDto.setAvailable(false);
            carService.update(carDto);
            return rentConverter.convertRentToRentDto(
                    rentPersistencePort.save(
                            rentConverter.convertCreationModelToRent(rentCreationModel, sessionService.getCurrentUser().getId(), price, nbDays)
                    )
            );
        }
        else
        {
            throw new RentException();
        }
    }


}
