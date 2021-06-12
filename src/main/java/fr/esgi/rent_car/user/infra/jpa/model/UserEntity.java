package fr.esgi.rent_car.user.infra.jpa.model;

import fr.esgi.rent_car.user.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserEntity {
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

        public UserEntity(String firstName, String lastName, String email, String userName, String password, LocalDate birthDate) {
            this.firstname = firstName;
            this.lastname = lastName;
            this.email = email;
            this.username = userName;
            this.password = password;
            this.birthdate = birthDate;
        }

}
