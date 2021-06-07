package fr.esgi.rent_car.car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String id;
    private String idOwner;
    private String description;
    private String location;
    private String location_cp;
    private String registration;
    private Double mileage;
    private String mark;
    private String engine;
    private Double price_day;
    private String mileage_max;
    private Date start_date;
    private Date end_date;
}
