package fr.esgi.rent_car.rent.domain.port;

import fr.esgi.rent_car.rent.domain.model.Rent;

public interface RentPersistencePort {
    Rent save(Rent location);
}
