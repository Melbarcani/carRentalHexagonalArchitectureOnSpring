package fr.esgi.rent_car.location.infra.web;

import fr.esgi.rent_car.location.domain.model.Location;
import fr.esgi.rent_car.location.domain.model.LocationDto;
import fr.esgi.rent_car.location.infra.jpa.model.LocationEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/location")
public interface LocationController {

    @PostMapping("/rent")
    Location saveLocation(@RequestBody LocationDto locationDto);

    @GetMapping("/id")
    Optional<Location> findLocationEntityById(String id);

    @GetMapping("/all")
    List<Location> findAll();

    @GetMapping("/car/id")
    List<Location> findAllById_car(@PathVariable String idCar);

    @GetMapping("/car/id")
    List<Location> findAllByIdAndId_user(@PathVariable String idUser);
}
