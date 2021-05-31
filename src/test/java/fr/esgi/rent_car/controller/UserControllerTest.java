package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.user.infra.web.UserController;
import fr.esgi.rent_car.user.infra.service.UserService;
import fr.esgi.rent_car.user.domain.User;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

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
    private User user;
    @BeforeEach
    void init(){
        userService = mock(UserService.class);
        userController = new UserController(userService);
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

   /* @Test
    void findAllTest(){
        when(userService.findAll()).thenReturn(Arrays.asList(user));
    }*/
}