package fr.esgi.rent_car.user.infra;

import fr.esgi.rent_car.user.domain.User;
import fr.esgi.rent_car.user.domain.UserDto;
import fr.esgi.rent_car.user.infra.hibernate.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {
    public User convertToUser(UserDao userDao) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(userDao, User.class);
    }

    public UserDao convertToUserDao(User user) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDao.class);
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
