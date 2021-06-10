package fr.esgi.rent_car.car.repository;

import fr.esgi.rent_car.car.domain.model.Car;
import fr.esgi.rent_car.car.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Optional<CarEntity> save(Car car);
    Optional<CarEntity> findCarById(String id);
    List<CarEntity> findCarByMark(String mark);
    List<CarEntity> findCarByLocation(String location);
    List<CarEntity> findCarByIdowner(String idOwner);
    List<CarEntity> findAll();
    void deleteCarById(String id);
}
