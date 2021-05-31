package fr.esgi.rent_car.user.infra;

import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.infra.jpa.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User convertToUser(UserEntity userDao) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(userDao, User.class);
    }

    public UserEntity convertToUserEntity(User user) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(user, UserEntity.class);
    }

    public UserDto convertToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getBirthdate(),
                user.getRole()
        );
    }
}
