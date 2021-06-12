package fr.esgi.rent_car.location.domain.port;

import fr.esgi.rent_car.location.domain.model.Rent;

public interface RentPersistencePort {
    Rent save(Rent location);
}
