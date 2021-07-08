package fr.esgi.rent_car.user.service;

import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.domain.port.UserPersistencePort;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.web.UserController;
import fr.esgi.rent_car.user.infra.web.rest.UserControllerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private static final String USER_ID_FOR_TEST = "id";
    private static final String EMAIL_FOR_TEST = "email@email.com";
    private static final String PASSWORD_FOR_TEST = "password";
    private static final String USERNAME_FOR_TEST = "username";
    private static final String FIRSTNAME_FOR_TEST = "firstname";
    private static final String LASTNAME_FOR_TEST = "lastname";
    private static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 1, 20);

    private UserConverter userConverter;
    private UserPersistencePort userPersistencePort;
    private UserService objectToTest;

    private User user;

    @BeforeEach
    void init() {
        userConverter = new UserConverter();
        userPersistencePort = mock(UserPersistencePort.class);
        objectToTest = new UserService(userPersistencePort, userConverter);
        userConverter = new UserConverter();
        user = createUser();
    }

    private User createUser() {
        return new User(
                FIRSTNAME_FOR_TEST,
                LASTNAME_FOR_TEST,
                EMAIL_FOR_TEST,
                USERNAME_FOR_TEST,
                PASSWORD_FOR_TEST,
                BIRTHDAY_FOR_TEST
        );
    }

    @Test
    void getUserById() {
        // Given
        user = createUser();
        when(userPersistencePort.getUserById(USER_ID_FOR_TEST)).thenReturn(user);
        // When
        UserDto userDto = objectToTest.getUserById(USER_ID_FOR_TEST);
        // Then
        verify(userPersistencePort, times(1)).getUserById(USER_ID_FOR_TEST);
        assertEquals(userConverter.convertToUserDto(user), userDto);
    }

    @Test
    void getAllUsers() {
        // Given
        user = createUser();
        UserDto userDto = userConverter.convertToUserDto(user);
        List<User> expectedUserList = Collections.singletonList(user);
        when(userPersistencePort.getAllUsers()).thenReturn(expectedUserList);
        // When
        List<UserDto> userDtoList = objectToTest.getAllUsers();
        // Then
        verify(userPersistencePort, times(1)).getAllUsers();
        assertTrue(Collections.singletonList(userDto).containsAll(userDtoList));
        assertTrue(userDtoList.contains(userDto));
    }
}