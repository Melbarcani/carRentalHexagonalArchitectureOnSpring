package fr.esgi.rent_car.car.infra.adapter.jpa;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.port.CarPersistencePort;
import fr.esgi.rent_car.car.repository.CarRepository;
import fr.esgi.rent_car.car.service.CarConverter;
import fr.esgi.rent_car.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarJpaAdapter implements CarPersistencePort {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    public Car createCar(Car car){
        return carConverter.convertToCar(carRepository.save(car).orElseThrow(() -> new ResourceNotFoundException("This car is not found : {0}")));
    }

    public Car getCarById(String id){
        return carConverter.convertToCar(carRepository.findCarById(id).orElseThrow(() -> new ResourceNotFoundException("This car is not found : {0}")));
    }

    public List<Car> findByMarque(String mark){
        return carConverter.convertToCarList(carRepository.findCarByMark(mark));
    }

    public List<Car> findByLocation(String location){
        return carConverter.convertToCarList(carRepository.findCarByLocation(location));
    }

    public List<Car> findByOwner(String owner){
        return carConverter.convertToCarList(carRepository.findCarByIdowner(owner));
    }

    public List<Car> findAll(){
        return carConverter.convertToCarList(carRepository.findAll());
    }

    public void deleteCar(String id) { carRepository.deleteCarById(id); }

    public Car update(Car car){
        return carConverter.convertToCar(carRepository.save(car).orElseThrow(() -> new ResourceNotFoundException("This car is not found : {0}")));
    }
}

