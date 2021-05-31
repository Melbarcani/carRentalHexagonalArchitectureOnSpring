package fr.esgi.rent_car.controller;

import fr.esgi.rent_car.service.AuthService;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class AuthControllerTest {
    protected static final String EMAIL_FOR_TEST = "email@email.com";
    protected static final String PASSWORD_FOR_TEST = "password";
    protected static final String USERNAME_FOR_TEST = "username";
    protected static final String FIRSTNAME_FOR_TEST = "firstname";
    protected static final String LASTNAME_FOR_TEST = "lastname";
    protected static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 2, 20);

    private AuthService authService;
    private AuthController authController;

    @BeforeEach
    void init() {
        authService = mock(AuthService.class);
        authController = new AuthController(authService);
    }

    /*private UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId("123");
        userDto.setBirthDate(BIRTHDAY_FOR_TEST);
        userDto.setEmail(EMAIL_FOR_TEST);
        userDto.setFirstName(FIRSTNAME_FOR_TEST);
        userDto.setLastName(LASTNAME_FOR_TEST);
        userDto.setPassword(PASSWORD_FOR_TEST);
        userDto.setUserName(USERNAME_FOR_TEST);
        return userDto;
    }

    private User createUser() {
        UserDto userDto = createUserDto();
        return new User( //next step : mapper
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getBirthDate()
        );
    }

    @Test
    void createUserTest() {
        UserDto userDto = createUserDto();
        User user = createUser();
        URI uri = fromPath("/api/users/").path("/{id}").buildAndExpand(user.getId()).toUri();
        when(authService.registerUser(user)).thenReturn(uri);

        var response = authController.create(userDto);

        assertEquals(new ResponseEntity<>(ResponseEntity.created(uri).build(), HttpStatus.CREATED), response);
    }

    @Test
    void loginTest() {
        LoginDto loginDto = new LoginDto(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        Login login = new Login(loginDto.getEmail(), loginDto.getPassword());

        HttpHeaders httpHeaders = new HttpHeaders();
        String token = "T0k3N";
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        when(authService.createSession(login)).thenReturn(httpHeaders);

        var response = authController.login(loginDto);

        assertEquals(new ResponseEntity<Login>(authService.createSession(login), HttpStatus.OK), response);
    }*/
}
