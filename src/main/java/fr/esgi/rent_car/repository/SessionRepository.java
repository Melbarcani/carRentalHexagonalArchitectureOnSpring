package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.model.Session;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.infra.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findByUser(UserEntity userEntity);
}
