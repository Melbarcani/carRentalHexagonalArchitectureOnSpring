package fr.esgi.rent_car.service;

import fr.esgi.rent_car.exception.AuthException;
import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user){
        return findUserByEmail(user.getEmail())
                .orElseThrow(() -> new AuthException("This email is already used by an other user"));

    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void findAll(){
        userRepository.findAll();
    }
}
