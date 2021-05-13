package fr.esgi.rent_car.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity (name = "car")
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String id;

    @Column
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
