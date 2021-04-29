package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Optional<Car> findById(String id);
    List<Car> findByMarque(String marque);
    List<Car> findByLocalisation(String localisation);
    List<Car> findById_owner(String owner);

    List<Car> findAll();

}
