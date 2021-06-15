package fr.esgi.rent_car.rent.infra.web.rest;

import fr.esgi.rent_car.rent.domain.model.RentDto;
import fr.esgi.rent_car.rent.exception.RentException;
import fr.esgi.rent_car.rent.infra.RentConverter;
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
    public final RentConverter locationConverter;

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
        return null;
    }

    @Override
    public List<RentDto> findAllById_car(String idCar) {
        return null;
    }

    @Override
    public List<RentDto> findAllByIdAndId_user(String idUser) {
        return null;
    }
}
