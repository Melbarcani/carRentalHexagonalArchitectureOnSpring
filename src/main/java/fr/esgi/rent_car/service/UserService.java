package fr.esgi.rent_car.service;

import fr.esgi.rent_car.exception.ConflictException;
import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findById(String id){
        return userRepository.findById(id).get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
