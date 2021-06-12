package fr.esgi.rent_car.location.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private String id_car;
    private String id_user;
    private int nb_day;
    private Double price;
    private Date start_date;
    private Date end_date;
}
