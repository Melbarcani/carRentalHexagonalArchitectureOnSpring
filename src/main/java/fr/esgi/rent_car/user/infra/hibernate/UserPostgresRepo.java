package fr.esgi.rent_car.user.infra.hibernate;

import fr.esgi.rent_car.user.domain.User;
import fr.esgi.rent_car.user.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserPostgresRepo extends JpaRepository<UserDao, Long> {

}
