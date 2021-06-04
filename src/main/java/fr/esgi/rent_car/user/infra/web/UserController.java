package fr.esgi.rent_car.user.infra.web;

import fr.esgi.rent_car.user.domain.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/user")
public interface UserController {

    @GetMapping("/all")
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable String id);
}
