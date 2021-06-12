package fr.esgi.rent_car.location.infra.jpa.repository;

import fr.esgi.rent_car.location.infra.jpa.model.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<RentEntity,Long> {

    RentEntity save(RentEntity locationEntity);

}
