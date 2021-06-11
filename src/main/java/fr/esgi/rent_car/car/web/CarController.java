package fr.esgi.rent_car.car.web;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/car")
public interface CarController {

    @PostMapping("/register")
    List<Car> createCar(@RequestBody CarDto carDto);

    @GetMapping("/{id}")
    Car getCarById(@PathVariable String id);

    @GetMapping("/all")
    List<Car> getAllCars();

    @GetMapping("/getMyCars")
    List<Car> findByOwner();

    @PostMapping("/location/{location}")
    List<CarDto> findByLocation(@PathVariable String location);

    @PostMapping("/delete")
    void deleteCarById(@RequestBody String id);

    /*@PutMapping("/update")
    CarDto update(@RequestBody Car car);*/
}
