package fr.esgi.rent_car.rent.domain.port;

import fr.esgi.rent_car.rent.domain.model.Rent;
import fr.esgi.rent_car.rent.domain.model.RentDto;

import java.util.List;

public interface RentPersistencePort {
    Rent save(Rent location);

    List<Rent> getAllRent();

    List<Rent> getAllRentByUserId(String idUser);
}
