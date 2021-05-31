package fr.esgi.rent_car.model;

import fr.esgi.rent_car.user.infra.jpa.model.UserEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Session {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private LocalDateTime createdAt;

    private String token;

    @ManyToOne
    private UserEntity user;

    public Session(String id, LocalDateTime createdAt, String token, UserEntity user) {
        this.id = id;
        this.createdAt = createdAt;
        this.token = token;
        this.user = user;
    }

    public Session() {

    }
}
