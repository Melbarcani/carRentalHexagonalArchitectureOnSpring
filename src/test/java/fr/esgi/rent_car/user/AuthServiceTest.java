package fr.esgi.rent_car.user;

import fr.esgi.rent_car.dto.UserDto;
import fr.esgi.rent_car.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

public class AuthServiceTest extends AbstractUserTest{

    @MockBean
    protected UserRepository userRepository;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createSessionTest(){
        UserDto userDto = new UserDto();
        userDto.setId("123");
        userDto.setBirthDate(BIRTHDAY_FOR_TEST);
        userDto.setEmail(EMAIL_FOR_TEST);
        userDto.setFirstName(FIRSTNAME_FOR_TEST);
        userDto.setLastName(LASTNAME_FOR_TEST);
        userDto.setPassword(PASSWORD_FOR_TEST);
        userDto.setUserName(USERNAME_FOR_TEST);


    }
}
