package fr.esgi.rent_car.service;

import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.exception.ConflictException;
import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Id unfounded"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
