package fr.esgi.rent_car.rent.infra.web.rest;

import fr.esgi.rent_car.rent.domain.model.RentDto;
import fr.esgi.rent_car.rent.exception.RentException;
import fr.esgi.rent_car.rent.infra.RentMapper;
import fr.esgi.rent_car.rent.infra.web.RentController;
import fr.esgi.rent_car.rent.infra.web.model.RentCreationModel;
import fr.esgi.rent_car.rent.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RentControllerImpl implements RentController {
    public final RentService rentService;
    public final RentMapper rentMapper;

    @Override
    public RentDto saveLocation(RentCreationModel rentCreationModel) throws RentException {
        return rentService.save(rentCreationModel);
    }

    @Override
    public Optional<RentDto> findLocationEntityById(String id) {
        return Optional.empty();
    }

    @Override
    public List<RentDto> findAll() {
        return rentService.getAllRent();
    }

    @Override
    public List<RentDto> findAllByUserId(String idUser) {
        return rentService.getAllRentByUserId(idUser);
    }
}
