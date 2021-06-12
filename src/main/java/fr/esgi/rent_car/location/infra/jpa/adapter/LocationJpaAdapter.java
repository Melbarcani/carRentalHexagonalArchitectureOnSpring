package fr.esgi.rent_car.location.infra.jpa.adapter;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.location.domain.model.Location;
import fr.esgi.rent_car.location.domain.model.LocationDto;
import fr.esgi.rent_car.location.domain.port.LocationPersistencePort;
import fr.esgi.rent_car.location.infra.LocationConverter;
import fr.esgi.rent_car.location.infra.jpa.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LocationJpaAdapter implements LocationPersistencePort {
    private final LocationRepository locationRepository;
    private final LocationConverter locationConverter;


    public void deleteLocation(String id) {

    }

    @Override
    public Location save(LocationDto locationDto) {
        return null;
    }
}
