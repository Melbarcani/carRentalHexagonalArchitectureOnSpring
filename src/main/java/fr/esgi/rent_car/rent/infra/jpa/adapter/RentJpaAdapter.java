package fr.esgi.rent_car.rent.infra.jpa.adapter;

import fr.esgi.rent_car.rent.domain.model.Rent;
import fr.esgi.rent_car.rent.domain.port.RentPersistencePort;
import fr.esgi.rent_car.rent.infra.RentMapper;
import fr.esgi.rent_car.rent.infra.jpa.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RentJpaAdapter implements RentPersistencePort {

    private final RentRepository rentRepository;
    private final RentMapper rentConverter;

    @Override
    public Rent save(Rent rent) {
        return rentConverter.convertEntityToRent(
                rentRepository.save(
                        rentConverter.convertRentToEntity(rent)));
    }

    @Override
    public List<Rent> getAllRent() {
        return rentConverter.convertEntityListToRentList(rentRepository.findAll());
    }

    @Override
    public List<Rent> getAllRentByUserId(String idUser) {
        return rentConverter.convertEntityListToRentList(rentRepository.findAllByIduser(idUser));
    }
}
