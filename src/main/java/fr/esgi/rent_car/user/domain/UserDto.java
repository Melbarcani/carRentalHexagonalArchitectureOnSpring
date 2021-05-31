package fr.esgi.rent_car.user.domain;

import fr.esgi.rent_car.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {

    private String id;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Role role = Role.USER;
}
