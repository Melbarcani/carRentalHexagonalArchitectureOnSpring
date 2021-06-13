package fr.esgi.rent_car.rent.infra.web.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class RentCreationModel {
    private String id_car;
    private LocalDate start_date;
    private LocalDate end_date;
}
