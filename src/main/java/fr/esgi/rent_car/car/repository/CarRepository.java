package fr.esgi.rent_car.car.repository;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    CarEntity save(CarEntity carEntity);
    Optional<CarEntity> findCarById(String id);
    List<CarEntity> findCarByLocation(String location);
    List<CarEntity> findCarByIdowner(String idOwner);
    List<CarEntity> findAll();
    void deleteCarById(String id);
}
