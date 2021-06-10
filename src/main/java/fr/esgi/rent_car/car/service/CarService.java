package fr.esgi.rent_car.car.service;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.domain.port.CarPersistencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
    private final CarPersistencePort carPersistencePort;
    private final CarConverter carConverter;

    public CarDto createCar(Car car){
        return carConverter.convertToCarDto(carPersistencePort.createCar(car));
    }

    public CarDto getCarById(String id){
        var car = carPersistencePort.getCarById(id);
        return carConverter.convertToCarDto(car);
    }

    public List<CarDto> getAllCars(){
        return carPersistencePort.findAll().stream().map(carConverter :: convertToCarDto).collect(Collectors.toList());
    }

    public List<CarDto> findByMarque(String mark){
        return carPersistencePort.findByMarque(mark).stream().map(carConverter :: convertToCarDto).collect(Collectors.toList());
    }

    public List<CarDto> findByLocation(String location){
        return carPersistencePort.findByLocation(location).stream().map(carConverter :: convertToCarDto).collect(Collectors.toList());
    }

    public List<CarDto> findByOwner(String owner){
        return carPersistencePort.findByOwner(owner).stream().map(carConverter :: convertToCarDto).collect(Collectors.toList());
    }

    public void deleteCar(String id) {
        carPersistencePort.deleteCar(id);
    }

    public CarDto update(Car car){
        Car carToUpdate = carPersistencePort.getCarById(car.getId());
        carToUpdate.setMileage(car.getMileage());
        return  carConverter.convertToCarDto(carPersistencePort.update(carToUpdate));
    }
}