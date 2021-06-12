package fr.esgi.rent_car.location.infra.web.rest;

import fr.esgi.rent_car.location.domain.model.RentDto;
import fr.esgi.rent_car.location.exception.RentException;
import fr.esgi.rent_car.location.infra.RentConverter;
import fr.esgi.rent_car.location.infra.web.RentController;
import fr.esgi.rent_car.location.infra.web.model.RentCreationModel;
import fr.esgi.rent_car.location.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RentControllerImpl implements RentController {
    public final RentService rentService;
    public final RentConverter locationConverter;

    @Override
    public RentDto saveLocation(RentCreationModel rentCreationModel) throws RentException {
        RentDto r = rentService.save(rentCreationModel);
        return r;
    }
}
