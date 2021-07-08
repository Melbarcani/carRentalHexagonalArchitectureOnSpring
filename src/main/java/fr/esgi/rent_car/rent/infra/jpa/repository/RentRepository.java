package fr.esgi.rent_car.rent.infra.jpa.repository;

import fr.esgi.rent_car.rent.infra.jpa.model.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<RentEntity,Long> {

    RentEntity save(RentEntity locationEntity);
    List<RentEntity> findAllByIduser(String id_user);
}
