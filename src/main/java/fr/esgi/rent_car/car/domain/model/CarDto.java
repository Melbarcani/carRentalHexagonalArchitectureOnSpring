package fr.esgi.rent_car.car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String description;
    private String location;
    private String location_cp;
    private Double price_day;
    private Date start_date;
    private Date end_date;
}
