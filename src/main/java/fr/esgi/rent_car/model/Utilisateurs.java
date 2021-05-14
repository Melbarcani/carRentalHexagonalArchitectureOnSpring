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
@Table(name = "utilisateurs", schema = "api")
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateurs {
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
    private String username;

    @Column
    @NotNull(message = "Password is required")
    private String password;

    @Column
    @NotNull(message = "First name is required")
    private String firstname;

    @Column
    @NotNull(message = "Last name is required")
    private String lastname;

    @Column(nullable = false)
    @NotNull(message = "Birthday is required")
    private LocalDate birthdate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column
    private String test;

    public Utilisateurs(String firstName, String lastName, String email, String userName, String password, LocalDate birthDate) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.username = userName;
        this.password = password;
        this.birthdate = birthDate;
    }
}
