package fr.esgi.rent_car.repository;

import fr.esgi.rent_car.user.domain.User;
import fr.esgi.rent_car.user.infra.hibernate.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
    Optional<UserDao> findById(String id);
    Optional<UserDao> findByEmail(String email);

    UserDao save(UserDao user);

}
