package fr.esgi.rent_car.user.infra.jpa.adapter;

import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.domain.port.UserPersistencePort;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserJpaAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public void addUser(User user) {
        userRepository.save(userConverter.convertToUserEntity(user));
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(userConverter.convertToUserEntity(user));
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(userConverter.convertToUserEntity(user));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().map(userConverter::convertToUser).collect(Collectors.toList());
    }

    @Override
    public User getUserById(String id) {
        return userConverter.convertToUser(
                userRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException(MessageFormat.format("There is no user with this Id : {0}", id)))
        );
    }

    @Override
    public User getUserByEmail(String email) {
        return userConverter.convertToUser(
                userRepository.findByEmail(email).orElseThrow(() ->
                        new ResourceNotFoundException(MessageFormat.format("There is no user with this email : {0}", email)))
        );
    }
}
