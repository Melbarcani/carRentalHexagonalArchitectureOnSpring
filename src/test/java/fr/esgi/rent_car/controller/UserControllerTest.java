package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.model.Users;
import fr.esgi.rent_car.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class UserControllerTest {

    private static final String TOKEN = "T0K3N";
    protected static final String EMAIL_FOR_TEST = "email@email.com";
    protected static final String PASSWORD_FOR_TEST = "password";
    protected static final String USERNAME_FOR_TEST = "username";
    protected static final String FIRSTNAME_FOR_TEST = "firstname";
    protected static final String LASTNAME_FOR_TEST = "lastname";
    protected static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 2, 20);


    private UserService userService;
    private UserController userController;
    private Users user;
    @BeforeEach
    void init(){
        userService = mock(UserService.class);
        userController = new UserController(userService);
        user = createUser();
    }

    private Users createUser() {
        return new Users(
                FIRSTNAME_FOR_TEST,
                LASTNAME_FOR_TEST,
                EMAIL_FOR_TEST,
                USERNAME_FOR_TEST,
                PASSWORD_FOR_TEST,
                BIRTHDAY_FOR_TEST
        );
    }

    @Test
    void findAllTest(){
        when(userService.findAll()).thenReturn(Arrays.asList(user));
    }
}