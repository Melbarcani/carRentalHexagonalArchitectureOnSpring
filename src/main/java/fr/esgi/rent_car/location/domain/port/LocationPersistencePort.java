package fr.esgi.rent_car.location.domain.port;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.location.domain.model.Location;
import fr.esgi.rent_car.location.domain.model.LocationDto;

import java.util.List;

public interface LocationPersistencePort {
    void deleteLocation(String id);

    Location save(LocationDto locationDto);
}
