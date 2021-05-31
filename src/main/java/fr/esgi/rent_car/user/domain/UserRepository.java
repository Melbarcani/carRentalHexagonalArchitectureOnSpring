package fr.esgi.rent_car.user.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);

    User save(User user);
}
