package fr.esgi.rent_car.user.infra.service;

import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userAdapter;

    public UserDto findById(String id){
        var userDao = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Id unfounded"));

        return userAdapter.convertToUserDto(userAdapter.convertToUser(userDao));
    }

    public List<UserDto> findAll(){
        return userRepository.findAll().stream().map(u -> userAdapter.convertToUserDto(userAdapter.convertToUser(u))).collect(Collectors.toList());
    }
}
