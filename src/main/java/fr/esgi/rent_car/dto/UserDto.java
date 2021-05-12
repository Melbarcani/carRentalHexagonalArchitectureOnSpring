package fr.esgi.rent_car.dto;

import fr.esgi.rent_car.model.Role;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDto {

    private String id;
    private String email;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Role role = Role.USER;
}
