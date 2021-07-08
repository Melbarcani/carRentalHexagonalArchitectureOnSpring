package fr.esgi.rent_car.car.infra.jpa.adapter;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.port.CarPersistencePort;
import fr.esgi.rent_car.car.infra.jpa.repository.CarRepository;
import fr.esgi.rent_car.car.infra.CarMapper;
import fr.esgi.rent_car.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarJpaAdapter implements CarPersistencePort {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public Car createCar(Car car){
        return carMapper.convertToCar(carRepository.save(carMapper.convertCarToEntity(car)));
    }

    public Car getCarById(String id){
        return carMapper.convertToCar(carRepository.findCarById(id).orElseThrow(() -> new ResourceNotFoundException("This car is not found : {0}")));
    }

    public List<Car> findByLocation(String location){
        return carMapper.convertToCarList(carRepository.findCarByLocation(location));
    }

    public List<Car> findByOwner(String owner){
        return carMapper.convertToCarList(carRepository.findCarByIdowner(owner));
    }

    public List<Car> findAll(){
        return carMapper.convertToCarList(carRepository.findAll());
    }

    @Override
    public List<Car> findAllAvailableCars() {
        return carMapper.convertToCarList(carRepository.findAllByAvailableTrue());
    }

    public void deleteCar(String id) { carRepository.deleteCarById(id); }

    public Car update(Car car){
        return carMapper.convertToCar(carRepository.save(carMapper.convertCarToEntity(car)));
    }
}

