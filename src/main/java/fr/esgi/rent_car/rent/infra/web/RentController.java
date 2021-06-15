package fr.esgi.rent_car.rent.infra.web;

import fr.esgi.rent_car.rent.domain.model.RentDto;
import fr.esgi.rent_car.rent.exception.RentException;
import fr.esgi.rent_car.rent.infra.web.model.RentCreationModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/rent")
public interface RentController {

    @PostMapping("/attempt")
    RentDto saveLocation(@RequestBody RentCreationModel rentCreationModel) throws RentException;

    @GetMapping("/id")
    Optional<RentDto> findLocationEntityById(String id);

    @GetMapping("/all")
    List<RentDto> findAll();

    @GetMapping("/car/id")
    List<RentDto> findAllById_car(@PathVariable String idCar);

    @GetMapping("/user/id")
    List<RentDto> findAllByIdAndId_user(@PathVariable String idUser);
}
