package fr.esgi.rent_car.car.infra.web.rest;

import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.infra.web.CarController;
import fr.esgi.rent_car.car.infra.web.model.CarCreationModel;
import fr.esgi.rent_car.car.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarControllerImpl implements CarController {
    private final CarService carService;

    public List<CarDto> createCar(@RequestBody CarCreationModel carCreationModel){
        carService.createCar(carCreationModel);
        return carService.findByOwner();
    }

    public CarDto getCarById(@RequestBody String id){
        return carService.getCarById(id);
    }

    public List<CarDto> getAllCars(){
        return carService.getAllCars();
    }

    @Override
    public List<CarDto> getAllAvailableCars() {
        return carService.getAllAvailableCars();
    }

    public List<CarDto> findByOwner(){
        return carService.findByOwner();
    }

    public List<CarDto> findByLocation(@PathVariable String location){
        return carService.findByLocation(location);
    }

    public void deleteCarById(@RequestBody String id){
        carService.deleteCar(id);
    }

   public CarDto update(CarDto carDto){
        return carService.update(carDto);}
}
