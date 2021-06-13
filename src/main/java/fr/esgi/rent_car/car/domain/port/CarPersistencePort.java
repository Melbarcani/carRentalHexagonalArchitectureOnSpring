package fr.esgi.rent_car.car.domain.port;

import fr.esgi.rent_car.car.domain.model.Car;

import java.util.List;

public interface CarPersistencePort {
    Car createCar(Car car);
    Car getCarById(String id);
    List<Car> findByLocation(String location);
    List<Car> findByOwner(String owner);
    List<Car> findAll();
    List<Car> findAllAvailableCars();
    void deleteCar(String id);
    Car update(Car car);
}
