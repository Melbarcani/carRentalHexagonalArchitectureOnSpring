package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.model.Car;
import fr.esgi.rent_car.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/register")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    @PostMapping("/all")
    public List<Car> findAllCar(){
        return carService.findAll();
    }

    @PostMapping("/{id}")
    public Optional<Car> findById(@PathVariable String id){return carService.findById(id);}

    @PostMapping("/marque/{mark}")
    public List<Car> findByMark(@PathVariable String mark){return carService.findByMarque(mark);}

    @PostMapping("/owner/{idOwner}")
    public List<Car>  findByOwner(@PathVariable String idOwner){return carService.findByOwner(idOwner);}

    @PostMapping("/localisation/{localisation}")
    public List<Car> findByLocation(@PathVariable String location){return carService.findByLocation(location);}

    @PostMapping("/delete")
    public void deleteCarById(@RequestBody String id){ carService.deleteCar(id); }
}
