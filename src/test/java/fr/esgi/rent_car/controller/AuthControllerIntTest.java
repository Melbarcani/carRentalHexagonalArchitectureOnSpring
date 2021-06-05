package fr.esgi.rent_car.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.rent_car.user.domain.model.LoginDto;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.service.AuthService;
import fr.esgi.rent_car.user.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class AuthControllerIntTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    ObjectMapper mapper;

    private MockMvc mvc;
    private User user;

    @BeforeEach
    public void setup() throws URISyntaxException {
        user = createUser();
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity()) // enable security for the mock set up
                .build();
    }

    @WithMockUser(value = "test", password = "pass")
    @Test
    void test() throws Exception {
        String jsonRequest = mapper.writeValueAsString(user);

        String contentType = MediaType.APPLICATION_JSON.toString();

        String authzToken = mvc
                .perform(
                        post("/api/auth/signup").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                                .
                        andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andReturn().getResponse().getContentAsString();

        System.out.print(authzToken);//{"token":"1a3434a"}
    }

    @WithMockUser(value = "test", password = "pass")
    @Test
    void testLogin() throws Exception {
        LoginDto loginDto = new LoginDto(EMAIL_FOR_TEST, PASSWORD_FOR_TEST);
        String jsonRequest = mapper.writeValueAsString(loginDto);

        String contentType = MediaType.APPLICATION_JSON.toString();

        String authzToken = mvc
                .perform(
                        post("/api/auth/login").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                //.andExpect(jsonPath("$.token", is(notNullValue())))
                .andReturn().getResponse().getContentAsString();

        System.out.print(authzToken);//{"token":"1a3434a"}
    }

    private static final String USER_ID_FOR_TEST = "id";
    private static final String EMAIL_FOR_TEST = "email@email.com";
    private static final String PASSWORD_FOR_TEST = "password";
    private static final String USERNAME_FOR_TEST = "username";
    private static final String FIRSTNAME_FOR_TEST = "firstname";
    private static final String LASTNAME_FOR_TEST = "lastname";
    private static final LocalDate BIRTHDAY_FOR_TEST = LocalDate.of(2000, 2, 20);



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
}
