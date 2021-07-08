package fr.esgi.rent_car.car.infra.web;

import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.infra.web.model.CarCreationModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/car")
public interface CarController {

    @PostMapping("/register")
    List<CarDto> createCar(@RequestBody CarCreationModel carCreationModel);

    @GetMapping("/getCar")
    CarDto getCarById(@RequestBody String id);

    @GetMapping("/all")
    List<CarDto> getAllCars();

    @GetMapping("/availableCars")
    List<CarDto> getAllAvailableCars();

    @GetMapping("/getMyCars")
    List<CarDto> findByOwner();

    @GetMapping("/location/{location}")
    List<CarDto> findByLocation(@PathVariable String location);

    @PostMapping("/delete")
    void deleteCarById(@RequestBody String id);

    @PutMapping("/update")
    CarDto update(@RequestBody CarDto carDto);
}
