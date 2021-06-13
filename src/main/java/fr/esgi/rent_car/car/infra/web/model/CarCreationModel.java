package fr.esgi.rent_car.car.infra.web.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class CarCreationModel {
    private String description;
    private String location;
    private String location_cp;
    private Double price_day;
    private LocalDate start_date;
    private LocalDate end_date;
}
