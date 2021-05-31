package fr.esgi.rent_car.user.domain.port;

import fr.esgi.rent_car.user.domain.model.User;

import java.util.List;

public interface UserPersistencePort {

    void addUser(User user);
    void removeUser(User user);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUserById(String id);
    User getUserByEmail(String email);
}
