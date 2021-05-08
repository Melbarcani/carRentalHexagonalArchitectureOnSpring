package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.dto.LoginDto;
import fr.esgi.rent_car.dto.UserDto;
import fr.esgi.rent_car.model.Login;
import fr.esgi.rent_car.model.Role;
import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.security.TokenProvider;
import fr.esgi.rent_car.service.AuthService;
import fr.esgi.rent_car.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.net.URI;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<Object> create(@RequestBody UserDto userDto) {
        var user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getBirthDate());
        var uri = authService.registerUser(user);
        return new ResponseEntity<>(ResponseEntity.created(uri).build(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody LoginDto loginDto) {
        var login = new Login(loginDto.getEmail(), loginDto.getPassword());
        return new ResponseEntity<>(authService.createSession(login), HttpStatus.OK);
    }
}
