package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /*@GetMapping
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<User>(userService.findAll());
    }*/
}
