package fr.esgi.rent_car.car.web;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/cars")
public interface CarController {

    @PostMapping("/register")
    CarDto createCar(@RequestBody Car car);

    @GetMapping("/all")
    List<CarDto> getAllCars();

    @GetMapping("/{id}")
    CarDto findById(@PathVariable String id);

    @GetMapping("/marque/{mark}")
    List<CarDto> findByMark(@PathVariable String mark);

    @GetMapping("/owner/{idOwner}")
    List<CarDto> findByOwner(@PathVariable String idOwner);

    @PostMapping("/location/{location}")
    List<CarDto> findByLocation(@PathVariable String location);

    @PostMapping("/delete")
    void deleteCarById(@RequestBody String id);

    @PutMapping("/update")
    CarDto update(@RequestBody Car car);
}
