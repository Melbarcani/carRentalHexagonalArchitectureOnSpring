package fr.esgi.rent_car.service;

import fr.esgi.rent_car.dto.UserDto;
import fr.esgi.rent_car.model.Login;
import fr.esgi.rent_car.model.Session;
import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.repository.SessionRepository;
import fr.esgi.rent_car.repository.UserRepository;
import fr.esgi.rent_car.security.TokenProvider;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthServiceTest {
    private AuthService authService;

    private static final String TOKEN = "T0K3N";
    protected static final String EMAIL_FOR_TEST = "email@email.com";
    protected static final String PASSWORD_FOR_TEST = "password";
    protected static final String USERNAME_FOR_TEST = "username";
    protected static final String FIRSTNAME_FOR_TEST = "firstname";
    protected static final String LASTNAME_FOR_TEST = "lastname";
    protected static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 2, 20);


    private TokenProvider tokenProvider;
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void init() {
        tokenProvider = mock(TokenProvider.class);
        authenticationManagerBuilder = mock(AuthenticationManagerBuilder.class);
        userRepository = mock(UserRepository.class);
        sessionRepository = mock(SessionRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        authService = new AuthService(
                tokenProvider,
                authenticationManagerBuilder,
                userRepository,
                sessionRepository,
                passwordEncoder
        );
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
    void createSessionTest() {
        when(tokenProvider.createToken(any())).thenReturn(TOKEN);
        User user = createUser();
        Login login = new Login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManagerBuilder.getObject()).thenReturn(authenticationManager);
        when(authenticationManagerBuilder.getObject().authenticate())

        authService.createSession(login);

        Mockito.verify(userRepository, times(1))
                .findByEmail(login.getEmail());

        Mockito.verify(sessionRepository, times(1))
                .save(new Session(user.getId(), null, TOKEN, user));
    }
}
