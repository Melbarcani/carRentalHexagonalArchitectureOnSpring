package fr.esgi.rent_car.location.infra.jpa.adapter;

import fr.esgi.rent_car.location.domain.model.Rent;
import fr.esgi.rent_car.location.domain.port.RentPersistencePort;
import fr.esgi.rent_car.location.infra.RentConverter;
import fr.esgi.rent_car.location.infra.jpa.model.RentEntity;
import fr.esgi.rent_car.location.infra.jpa.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RentJpaAdapter implements RentPersistencePort {

    private final RentRepository rentRepository;
    private final RentConverter rentConverter;

    @Override
    public Rent save(Rent rent) {
        RentEntity rentEntity = rentConverter.convertRentToEntity(rent);
        return rentConverter.convertEntityToRent(
                rentRepository.save(rentEntity));
    }
}
