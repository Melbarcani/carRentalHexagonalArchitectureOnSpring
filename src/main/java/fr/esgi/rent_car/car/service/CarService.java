package fr.esgi.rent_car.car.service;

import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.domain.port.CarPersistencePort;
import fr.esgi.rent_car.car.infra.CarConverter;
import fr.esgi.rent_car.car.infra.web.model.CarCreationModel;
import fr.esgi.rent_car.user.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
    private final CarPersistencePort carPersistencePort;
    private final CarConverter carConverter;
    private final SessionService sessionService;

    public CarDto createCar(CarCreationModel carCreationModel){

        var car = carConverter.convertCreationModelToCar(carCreationModel,sessionService.getCurrentUser().getId());
        return carConverter.convertToCarDto(carPersistencePort.createCar(car));
    }

    public CarDto getCarById(String id){
        return carConverter.convertToCarDto(carPersistencePort.getCarById(id));

    }

    public List<CarDto> getAllCars(){
        return carConverter.convertCarToCarDtoList(carPersistencePort.findAll());
    }

    public List<CarDto> findByLocation(String location){
        return carPersistencePort.findByLocation(location).stream().map(carConverter :: convertToCarDto).collect(Collectors.toList());
    }

    public List<CarDto> findByOwner(){
        return carConverter.convertCarToCarDtoList(carPersistencePort.findByOwner(sessionService.getCurrentUser().getId()));
    }

    public void deleteCar(String id) {
        carPersistencePort.deleteCar(id);
    }


    public CarDto update(CarDto carDto){
        return  carConverter.convertToCarDto(
                    carPersistencePort.update(
                        carConverter.convertDtoToCar(carDto)));
    }

    public List<CarDto> getAllAvailableCars() {
        return carConverter.convertCarToCarDtoList(carPersistencePort.findAllAvailableCars());
    }
}