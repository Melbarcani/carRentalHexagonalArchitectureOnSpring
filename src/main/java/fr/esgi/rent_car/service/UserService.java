package fr.esgi.rent_car.service;

import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.model.Utilisateurs;
import fr.esgi.rent_car.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public Utilisateurs findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Id unfounded"));
    }

    public List<Utilisateurs> findAll(){
        return userRepository.findAll();
    }
}
