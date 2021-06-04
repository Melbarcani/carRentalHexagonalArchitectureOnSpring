package fr.esgi.rent_car.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;

    private String email;

    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    private Role role = Role.USER;

    private String test;

    public User(String firstName, String lastName, String email, String userName, String password, LocalDate birthDate) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.username = userName;
        this.password = password;
        this.birthdate = birthDate;
    }
}
