package fr.esgi.rent_car.car.service;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.domain.port.CarPersistencePort;
import fr.esgi.rent_car.car.model.CarEntity;
import fr.esgi.rent_car.model.Session;
import fr.esgi.rent_car.user.service.SessionService;
import fr.esgi.rent_car.user.service.UserService;
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

    public CarDto createCar(CarDto carDto){
        CarEntity carEntity = carConverter.convertDtoToCarEntity(carDto,sessionService.getCurrentUser().getId());
        return carConverter.convertToCarDto(carPersistencePort.createCar(carEntity));
    }

    public Car getCarById(String id){
        return carPersistencePort.getCarById(id);

    }

    public List<Car> getAllCars(){
        return carPersistencePort.findAll();
    }

    public List<CarDto> findByLocation(String location){
        return carPersistencePort.findByLocation(location).stream().map(carConverter :: convertToCarDto).collect(Collectors.toList());
    }

    public List<Car> findByOwner(){
        return carPersistencePort.findByOwner(sessionService.getCurrentUser().getId());
    }

    public void deleteCar(String id) {
        carPersistencePort.deleteCar(id);
    }

    /*
    public CarDto update(Car car){
        CarEntity carToUpdate = carPersistencePort.getCarById(car.getId());
        // A changer
        return  carConverter.convertToCarDto(carPersistencePort.update(carToUpdate));
    }*/
}