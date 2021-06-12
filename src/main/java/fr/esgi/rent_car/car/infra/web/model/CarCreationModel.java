package fr.esgi.rent_car.car.infra.web.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class CarCreationModel {
    private String description;
    private String location;
    private String location_cp;
    private Double price_day;
    private Date start_date;
    private Date end_date;
}
