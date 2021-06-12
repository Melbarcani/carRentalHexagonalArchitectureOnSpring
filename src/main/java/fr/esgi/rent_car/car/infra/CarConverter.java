package fr.esgi.rent_car.car.infra;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.domain.model.CarDto;
import fr.esgi.rent_car.car.infra.jpa.model.CarEntity;
import fr.esgi.rent_car.car.infra.web.model.CarCreationModel;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.swing.text.Caret;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarConverter {
    public CarDto convertToCarDto(Car car) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(car, CarDto.class);
    }

    public Car convertDtoToCar(CarDto carDto) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(carDto, Car.class);
    }

    public Car convertCreationModelToCar(CarCreationModel carCreationModel, String idOwner) {
        return new Car("", idOwner, carCreationModel.getDescription(), carCreationModel.getLocation(),
                carCreationModel.getLocation_cp(), carCreationModel.getPrice_day(), carCreationModel.getStart_date(), carCreationModel.getEnd_date());
    }

    public CarEntity convertCarToEntity(Car car){
        var modelMapprer = new ModelMapper();
        return modelMapprer.map(car, CarEntity.class);
    }

    public Car convertToCar(CarEntity carEntity) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(carEntity, Car.class);
    }

    public List<Car> convertToCarList(List<CarEntity> carEntityList) {
        return carEntityList.stream().map(this::convertToCar).collect(Collectors.toList());
    }

    public List<CarDto> convertCarToCarDtoList(List<Car> car) {
        return car.stream().map(this::convertToCarDto).collect(Collectors.toList());
    }
}
