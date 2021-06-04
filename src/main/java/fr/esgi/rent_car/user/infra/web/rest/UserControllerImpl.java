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

    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    public ResponseEntity<UserDto> getUserById(@PathVariable String id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
