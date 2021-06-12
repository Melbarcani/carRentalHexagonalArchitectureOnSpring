package fr.esgi.rent_car.location.infra.web.rest;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.infra.web.CarController;
import fr.esgi.rent_car.location.domain.model.Location;
import fr.esgi.rent_car.location.domain.model.LocationDto;
import fr.esgi.rent_car.location.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationControllerImpl implements CarController {
    public final LocationService locationService;

    public List<Car> createCar(CarDto carDto) {
        return locationService.save(carDto);
    }

    public Car getCarById(String id) {
        return null;
    }

    public List<Car> getAllCars() {
        return null;
    }

    public List<Car> findByOwner() {
        return null;
    }

    public List<CarDto> findByLocation(String location) {
        return null;
    }

    public void deleteCarById(String id) {

    }
}
