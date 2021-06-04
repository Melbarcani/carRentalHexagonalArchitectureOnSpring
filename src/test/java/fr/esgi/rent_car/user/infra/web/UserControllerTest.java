package fr.esgi.rent_car.user.infra.web;


import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.web.rest.UserControllerImpl;
import fr.esgi.rent_car.user.service.UserService;
import fr.esgi.rent_car.user.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {
    private static final String USER_ID_FOR_TEST = "id";
    private static final String EMAIL_FOR_TEST = "email@email.com";
    private static final String PASSWORD_FOR_TEST = "password";
    private static final String USERNAME_FOR_TEST = "username";
    private static final String FIRSTNAME_FOR_TEST = "firstname";
    private static final String LASTNAME_FOR_TEST = "lastname";
    private static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 2, 20);

    private UserConverter userConverter;

    private UserService userService;
    private UserController objectToTest;
    private User user;

    @BeforeEach
    void init() {
        userService = mock(UserService.class);
        objectToTest = new UserControllerImpl(userService);
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
    void findAllTest() {
        // Given
        user = createUser();
        List<UserDto> expectedUserDtoList = Collections.singletonList(userConverter.convertToUserDto(user));
        when(userService.getAllUsers()).thenReturn(expectedUserDtoList);

        // When
        ResponseEntity<List<UserDto>> responseEntity = objectToTest.getAllUsers();
        List<UserDto> users = responseEntity.getBody();
        HttpStatus httpStatus = responseEntity.getStatusCode();

        // Then
        Mockito.verify(userService, times(1)).getAllUsers();
        assert users != null;
        assertTrue(users.containsAll(expectedUserDtoList));
        assertTrue(expectedUserDtoList.containsAll(users));
        assertEquals(HttpStatus.OK, httpStatus);
    }

    @Test
    void getUserByIdTest() {
        //Given
        user = createUser();
        when(userService.getUserById(USER_ID_FOR_TEST)).thenReturn(userConverter.convertToUserDto(user));

        //When
        ResponseEntity<UserDto> response = objectToTest.getUserById(USER_ID_FOR_TEST);
        UserDto userDto = response.getBody();

        //Then
        Mockito.verify(userService, times(1)).getUserById(USER_ID_FOR_TEST);
        assertEquals(userConverter.convertToUserDto(user), userDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}