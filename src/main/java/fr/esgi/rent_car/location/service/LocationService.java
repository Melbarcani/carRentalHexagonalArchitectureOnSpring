package fr.esgi.rent_car.location.service;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.location.domain.model.Location;
import fr.esgi.rent_car.location.domain.model.LocationDto;
import fr.esgi.rent_car.location.domain.port.LocationPersistencePort;
import fr.esgi.rent_car.location.infra.LocationConverter;
import fr.esgi.rent_car.user.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
    private final LocationPersistencePort locationPersistencePort;
    private final LocationConverter locationConverter;
    private final SessionService sessionService;


    public Location save(LocationDto carDto) {
        return locationPersistencePort.save(carDto);
    }

    public void deleteLocation(String id) {
        locationPersistencePort.deleteLocation(id);
    }
}
