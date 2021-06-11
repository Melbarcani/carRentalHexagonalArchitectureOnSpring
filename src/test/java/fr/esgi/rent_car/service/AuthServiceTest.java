package fr.esgi.rent_car.service;

import fr.esgi.rent_car.repository.SessionRepository;
import fr.esgi.rent_car.user.infra.security.TokenProvider;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.jpa.repository.UserRepository;
import fr.esgi.rent_car.user.service.AuthService;
import fr.esgi.rent_car.user.service.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;

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
    private UserConverter userAdapter;
    private SessionService sessionService;

    @BeforeEach
    void init() {
        tokenProvider = mock(TokenProvider.class);
        userRepository = mock(UserRepository.class);
        sessionRepository = mock(SessionRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        userAdapter = mock(UserConverter.class);
        authService = new AuthService(
                tokenProvider,
                authenticationManagerBuilder,
                userRepository,
                sessionRepository,
                passwordEncoder,
                userAdapter,
                sessionService
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

    /*@Test
    void createSessionTest() throws Exception {
        when(tokenProvider.createToken(any())).thenReturn(TOKEN);
        User user = createUser();
        Login login = new Login(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getEmail(), login.getPassword()
        );
        ObjectPostProcessor<Object> opp = mock(ObjectPostProcessor.class);
        AuthenticationManagerBuilder builder = mock(AuthenticationManagerBuilder.class);
        AuthenticationProvider provider = mock(AuthenticationProvider.class);
        builder.objectPostProcessor(opp);
        builder.authenticationProvider(provider);

        authService.createSession(login);

        Mockito.verify(userRepository, times(1))
                .findByEmail(login.getEmail());

        Mockito.verify(sessionRepository, times(1))
                .save(new Session(user.getId(), null, TOKEN, user));
    }*/
}
