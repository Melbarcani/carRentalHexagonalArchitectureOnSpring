package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    Optional<Car> findCarById(String id);
    List<Car> findCarByMark(String mark);
    List<Car> findCarByLocation(String location);
    List<Car> findCarById_owner(String owner);

    List<Car> findAll();
    void deleteCarById(String id);

    /*@Query("update Car c set c.marque = :marque WHERE c.id = :customerId")
    void setCustomerName(@Param("carId") String id, @Param("marque") String marque);*/

}
