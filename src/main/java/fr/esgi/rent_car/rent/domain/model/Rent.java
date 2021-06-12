package fr.esgi.rent_car.location.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    private String id;
    private String id_car;
    private String id_user;
    private int nb_day;
    private Double price;
    private LocalDate start_date;
    private LocalDate end_date;
}
