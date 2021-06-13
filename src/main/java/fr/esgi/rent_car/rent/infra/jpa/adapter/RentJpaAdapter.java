package fr.esgi.rent_car.rent.infra.jpa.adapter;

import fr.esgi.rent_car.rent.domain.model.Rent;
import fr.esgi.rent_car.rent.domain.port.RentPersistencePort;
import fr.esgi.rent_car.rent.infra.RentConverter;
import fr.esgi.rent_car.rent.infra.jpa.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RentJpaAdapter implements RentPersistencePort {

    private final RentRepository rentRepository;
    private final RentConverter rentConverter;

    @Override
    public Rent save(Rent rent) {
        return rentConverter.convertEntityToRent(
                rentRepository.save(
                        rentConverter.convertRentToEntity(rent)));
    }
}
