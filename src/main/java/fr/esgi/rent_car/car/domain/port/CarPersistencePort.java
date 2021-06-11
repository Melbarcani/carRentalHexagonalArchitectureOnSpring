package fr.esgi.rent_car.car.domain.port;


import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.model.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarPersistencePort {
    Car createCar(CarEntity carEntity);
    Car getCarById(String id);
    List<Car> findByLocation(String location);
    List<Car> findByOwner(String owner);
    List<Car> findAll();
    void deleteCar(String id);
    //Car update(CarEntity carEntity);
}
