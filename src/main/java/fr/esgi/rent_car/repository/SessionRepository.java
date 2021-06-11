package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.model.Session;
import fr.esgi.rent_car.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {}
