package fr.esgi.rent_car.location.infra;

import fr.esgi.rent_car.location.domain.model.Rent;
import fr.esgi.rent_car.location.domain.model.RentDto;
import fr.esgi.rent_car.location.infra.jpa.model.RentEntity;
import fr.esgi.rent_car.location.infra.web.model.RentCreationModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class RentConverter {

    public Rent convertCreationModelToRent(RentCreationModel rentCreationModel, String user_id, double price, int nbDay) {
        return new Rent("",rentCreationModel.getId_car(),user_id,nbDay,price,rentCreationModel.getStart_date(),rentCreationModel.getEnd_date());
    }

    public RentDto convertRentToRentDto(Rent rent) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(rent, RentDto.class);
    }

    public RentEntity convertRentToEntity(Rent rent) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(rent, RentEntity.class);
    }

    public Rent convertEntityToRent(RentEntity rentEntity) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(rentEntity, Rent.class);
    }
}
