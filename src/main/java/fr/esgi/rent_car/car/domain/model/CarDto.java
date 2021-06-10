package fr.esgi.rent_car.car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CarDto {
    private String id;
    private String idowner;
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
