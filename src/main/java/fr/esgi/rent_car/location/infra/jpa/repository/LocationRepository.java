package fr.esgi.rent_car.location.infra.jpa.repository;

import fr.esgi.rent_car.location.infra.jpa.model.LocationEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {

    LocationEntity save(LocationEntity locationEntity);
    void deleteById(String id);

    Optional<LocationEntity> findLocationEntityById(String id);
    List<LocationEntity> findAll();

    List<LocationEntity> findAllById_car(String idCar);
    List<LocationEntity> findAllByIdAndId_user(String idUser);

}
