package fr.esgi.rent_car.car.service;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.model.CarEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarConverter {
    public CarDto convertToCarDto(Car car) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(car, CarDto.class);
    }

    public CarEntity convertDtoToCarEntity(CarDto carDto, String idOwner) {
        return new CarEntity("", idOwner, carDto.getDescription(), carDto.getLocation(),
                carDto.getLocation_cp(), carDto.getPrice_day(), carDto.getStart_date(), carDto.getEnd_date());
    }

    public Car convertToCar(CarEntity carEntity) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(carEntity, Car.class);
    }

    public List<Car> convertToCarList(List<CarEntity> carEntityList) {
        return carEntityList.stream().map(this::convertToCar).collect(Collectors.toList());
    }
}
