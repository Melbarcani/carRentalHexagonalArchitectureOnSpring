package fr.esgi.rent_car.user.infra.jpa.repository;

import fr.esgi.rent_car.user.infra.web.model.Session;
import fr.esgi.rent_car.user.infra.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findByUser(UserEntity userEntity);
}
