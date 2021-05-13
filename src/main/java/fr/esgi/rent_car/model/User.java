package fr.esgi.rent_car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(unique = true)
    @NotNull(message = "Email is required")
    private String email;

    @Column(unique = true, nullable = false)
    @NotNull(message = "Username is required")
    private String userName;

    @Column
    @NotNull(message = "Password is required")
    private String password;

    @Column
    @NotNull(message = "First name is required")
    private String firstName;

    @Column
    @NotNull(message = "Last name is required")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Birthday is required")
    private LocalDate birthDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public User(String firstName, String lastName, String email, String userName, String password, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
    }
}
