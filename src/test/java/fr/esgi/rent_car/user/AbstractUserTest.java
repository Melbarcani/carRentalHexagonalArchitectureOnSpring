package fr.esgi.rent_car.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import fr.esgi.rent_car.model.Login;
import fr.esgi.rent_car.model.User;
import fr.esgi.rent_car.service.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public abstract class AbstractUserTest {
    protected static final String EMAIL_FOR_TEST = "email@email.com";
    protected static final String PASSWORD_FOR_TEST = "password";
    protected static final String USERNAME_FOR_TEST = "username";
    protected static final String FIRSTNAME_FOR_TEST = "firstname";
    protected static final String LASTNAME_FOR_TEST = "lastname";
    protected static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 2,20);
    protected static final String AUTH_HEADER = "Authorization";

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Before
    public void setup(){
        final User user = new User(
                FIRSTNAME_FOR_TEST,
                LASTNAME_FOR_TEST,
                EMAIL_FOR_TEST,
                USERNAME_FOR_TEST,
                new BCryptPasswordEncoder().encode(PASSWORD_FOR_TEST),
                BIRTHDAY_FOR_TEST);
        user.setId("123");

        given(userService.findUserByEmail(user.getEmail())).willReturn(Optional.of(user));
    }

    public ResultActions login(String username, String password) throws Exception {
        Login login = new Login(username, password);
        return mockMvc.perform(
                post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(login))
        );
    }
    public MockHttpServletRequestBuilder doGet(String url) {
        return get(url).header(AUTH_HEADER, getHeader());
    }

    public MockHttpServletRequestBuilder doPost(String url) {
        return post(url).header(AUTH_HEADER, getHeader());
    }

    private String getHeader() {
        try {
            MvcResult result = login(USERNAME_FOR_TEST, PASSWORD_FOR_TEST).andReturn();
            String token = JsonPath.read(result.getResponse().getContentAsString(), "$.token");
            return String.format("Bearer %s", token);
        }catch (Exception ex) {
            return null;
        }
    }

}
