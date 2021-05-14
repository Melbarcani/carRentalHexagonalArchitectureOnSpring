package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateurs, Long> {
    Optional<Utilisateurs> findById(String id);
    Optional<Utilisateurs> findByEmail(String email);

    Utilisateurs save(Utilisateurs user);

}
