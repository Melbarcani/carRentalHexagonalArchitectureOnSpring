package fr.esgi.rent_car.user.infra.web.model;

import fr.esgi.rent_car.user.domain.model.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class UserCreationModel {
    private String id;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private Role role = Role.USER;
}
