package fr.esgi.rent_car.car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String id;
    private String idOwner;
    private String description;
    private String location;
    private String location_cp;
    private Double price_day;
    private LocalDate start_date;
    private LocalDate end_date;
    private Boolean available;
}
