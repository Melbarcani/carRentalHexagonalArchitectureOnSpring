package fr.esgi.rent_car.service;

import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.model.Users;
import fr.esgi.rent_car.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public Users findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Id unfounded"));
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }
}
