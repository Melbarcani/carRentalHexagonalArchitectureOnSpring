package fr.esgi.rent_car.user.infra.web;

import fr.esgi.rent_car.user.domain.model.Login;
import fr.esgi.rent_car.user.domain.model.LoginDto;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.infra.web.model.UserCreationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthController {

    @PostMapping("/signup")
    ResponseEntity<Object> create(@RequestBody UserCreationModel userCreationModel);

    @PostMapping("/login")
    ResponseEntity<Login> login(@RequestBody LoginDto loginDto);
}
