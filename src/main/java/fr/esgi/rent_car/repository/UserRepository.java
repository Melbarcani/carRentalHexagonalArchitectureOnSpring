package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(String id);
    Optional<Users> findByEmail(String email);

    Users save(Users user);

}
