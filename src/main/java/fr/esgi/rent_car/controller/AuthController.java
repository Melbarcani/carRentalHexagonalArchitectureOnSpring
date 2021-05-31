package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.dto.LoginDto;
import fr.esgi.rent_car.user.domain.User;
import fr.esgi.rent_car.user.domain.UserDto;
import fr.esgi.rent_car.model.Login;
import fr.esgi.rent_car.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Object> create(@RequestBody User user) {
        var uri = authService.registerUser(user);
        return new ResponseEntity<>(ResponseEntity.created(uri).build(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody LoginDto loginDto) {
        var login = new Login(loginDto.getEmail(), loginDto.getPassword());
        return new ResponseEntity<>(authService.createSession(login), HttpStatus.OK);
    }
}
