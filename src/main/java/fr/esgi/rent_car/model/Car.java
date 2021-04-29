package fr.esgi.rent_car.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity (name = "voiture")
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
    private String id_owner;

    @Column
    private String description;

    @Column
    private String localisation;

    @Column
    private String localisationCP;

    @Column
    private String immatriculation;

    @Column
    private Double kilometrage;

    @Column
    private String marque;

    @Column
    private String moteur;

    @Column
    private Double prix_jour;

    @Column
    private String kilometrage_max;

    @Column
    private Date date_debut;

    @Column
    private Date date_fin;
}
