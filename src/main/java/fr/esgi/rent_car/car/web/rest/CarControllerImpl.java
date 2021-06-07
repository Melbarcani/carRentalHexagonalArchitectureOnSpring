package fr.esgi.rent_car.car.web.rest;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.service.CarService;
import fr.esgi.rent_car.car.web.CarController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarControllerImpl implements CarController {
    private final CarService carService;
    public CarDto createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    public List<CarDto> getAllCars(){
        return carService.getAllCars();
    }

    public CarDto findById(@PathVariable String id){
        return carService.getCarById(id);
    }

    public List<CarDto> findByMark(@PathVariable String mark){
        return carService.findByMarque(mark);
    }

    public List<CarDto>  findByOwner(@PathVariable String idOwner){
        return carService.findByOwner(idOwner);
    }

    public List<CarDto> findByLocation(@PathVariable String location){
        return carService.findByLocation(location);
    }

    public void deleteCarById(@RequestBody String id){
        carService.deleteCar(id);
    }

    public CarDto update(Car car){
        return carService.update(car);
    }
}
