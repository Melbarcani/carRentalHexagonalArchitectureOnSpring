package fr.esgi.rent_car.user.infra.web.rest;

import fr.esgi.rent_car.user.service.UserService;
import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.infra.web.UserController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> findById(@PathVariable String id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
