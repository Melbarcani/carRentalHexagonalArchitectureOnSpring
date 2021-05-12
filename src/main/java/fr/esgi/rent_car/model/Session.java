package fr.esgi.rent_car.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name ="session")
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
    private User user;

    public Session(String id, LocalDateTime createdAt, String token, User user) {
        this.id = id;
        this.createdAt = createdAt;
        this.token = token;
        this.user = user;
    }

    public Session() {

    }
}
