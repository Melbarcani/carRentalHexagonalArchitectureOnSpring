package fr.esgi.rent_car.location.infra;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.infra.jpa.model.CarEntity;
import fr.esgi.rent_car.location.domain.model.Location;
import fr.esgi.rent_car.location.domain.model.LocationDto;
import fr.esgi.rent_car.location.infra.jpa.model.LocationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class LocationConverter {

    public LocationDto convertToLocationDto(Location location) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(location, LocationDto.class);
    }

    public Location convertToLocation(LocationEntity locationEntity) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(locationEntity, Location.class);
    }

    public List<Location> convertToLocationList(List<LocationEntity> locationEntityList) {
        return locationEntityList.stream().map(this::convertToLocation).collect(Collectors.toList());
    }

    public LocationEntity convertDtoToLocationEntity(LocationDto locationDto) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(locationDto, LocationEntity.class);
    }
}
