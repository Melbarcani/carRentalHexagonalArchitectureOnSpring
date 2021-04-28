package fr.esgi.rent_car.service;

import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public void findAll(){
        userRepository.findAll();
    }
}
