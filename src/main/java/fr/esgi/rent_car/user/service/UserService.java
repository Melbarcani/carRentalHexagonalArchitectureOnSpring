package fr.esgi.rent_car.user.service;

import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.domain.port.UserPersistencePort;
import fr.esgi.rent_car.user.infra.UserConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserPersistencePort userPersistencePort;
    private final UserConverter userAdapter;

    public UserDto findById(String id){
        var user = userPersistencePort.getUserById(id);

        return userAdapter.convertToUserDto(user);
    }

    public List<UserDto> findAll(){
        return userPersistencePort.getAllUsers().stream().map(userAdapter::convertToUserDto).collect(Collectors.toList());
    }
}
