package fr.esgi.rent_car.user.infra.web.rest;

import fr.esgi.rent_car.user.domain.model.LoginDto;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.domain.model.Login;
import fr.esgi.rent_car.user.infra.web.model.UserCreationModel;
import fr.esgi.rent_car.user.service.AuthService;
import fr.esgi.rent_car.user.infra.web.AuthController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;

    @Override
    public ResponseEntity<Object> create(@RequestBody UserCreationModel userCreationModel) {
        var uri = authService.registerUser(userCreationModel);
        return new ResponseEntity<>(ResponseEntity.created(uri).build(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Login> login(@RequestBody LoginDto loginDto) {
        var login = new Login(loginDto.getEmail(), loginDto.getPassword());
        HttpHeaders h = authService.createSession(login);
        return new ResponseEntity<>( h , HttpStatus.OK);
    }
}
