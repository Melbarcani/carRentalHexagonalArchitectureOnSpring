package fr.esgi.rent_car.service;

import fr.esgi.rent_car.model.Car;
import fr.esgi.rent_car.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car createCar(Car car){ return this.carRepository.save(car); }

    public Optional<Car> findById(String id){return this.carRepository.findCarById(id);}

    public List<Car> findByMarque(String mark){return this.carRepository.findCarByMark(mark);}

    public List<Car> findByLocation(String location){return this.carRepository.findCarByLocation(location);}

    public List<Car> findByOwner(String owner){return this.carRepository.findCarByIdowner(owner);}

    public List<Car> findAll(){return this.carRepository.findAll();}

    public void deleteCar(String id) { this.carRepository.deleteCarById(id); }

    public Car update(Car car){
        Car carToUpdate = this.carRepository.getOne(car.getId());
        carToUpdate.setMileage(car.getMileage());
        return this.carRepository.save(carToUpdate);
    }
}
