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

    public Optional<Car> findById(String id){return this.carRepository.findById(id);}

    public List<Car>  findByMarque(String marque){return this.carRepository.findByMarque(marque);}

    public List<Car>  findByLocalisation(String localisation){return this.carRepository.findByLocalisation(localisation);}

    public List<Car>  findByOwner(String owner){return this.carRepository.findByIdOwner(owner);}

    public List<Car> findAll(){return this.carRepository.findAll();}

}
