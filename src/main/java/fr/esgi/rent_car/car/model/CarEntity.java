package fr.esgi.rent_car.car.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(updatable = false, nullable = false)
    private String id;

    @Column
    @NotNull
    private String idowner;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private String location_cp;

    @Column
    private String registration;

    @Column
    private Double mileage;

    @Column
    private String mark;

    @Column
    private String engine;

    @Column
    private Double price_day;

    @Column
    private String mileage_max;

    @Column
    private Date start_date;

    @Column
    private Date end_date;
}


