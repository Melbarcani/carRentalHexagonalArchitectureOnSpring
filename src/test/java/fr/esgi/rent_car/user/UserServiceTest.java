package fr.esgi.rent_car.user;

import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.repository.UserRepository;
import fr.esgi.rent_car.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;


@AutoConfigureMockMvc
public class UserServiceTest extends AbstractUserTest{

    @MockBean
    protected UserRepository userRepository;

    @Autowired
    private UserService userService;



    @Test
    public void findAllShouldReturnJsonArray(){
        final User user = new User(
                FIRSTNAME_FOR_TEST,
                LASTNAME_FOR_TEST,
                EMAIL_FOR_TEST,
                USERNAME_FOR_TEST,
                new BCryptPasswordEncoder().encode(PASSWORD_FOR_TEST),
                BIRTHDAY_FOR_TEST);
        user.setId("123");

        given(userRepository.findAll()).willReturn(Arrays.asList(user));
        assertThat(userService.findAll()).hasSize(1).contains(user);
    }

}
