package fr.esgi.rent_car.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.rent_car.user.domain.model.Login;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.domain.model.UserDto;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.jpa.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@SpringBootTest
@AutoConfigureMockMvc
class TestAuthApi {

    private final MockMvc mockMvc;
    private final ObjectMapper mapper;
    private final UserConverter userConverter;

    @Mock
    private UserRepository userRepository;

    private final String password = "Test12345_";

    @Autowired
    public TestAuthApi(MockMvc mockMvc, ObjectMapper mapper, UserConverter userConverter) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
        this.userConverter = userConverter;
    }

    @Test
    void testRegisterSuccess() throws Exception {
        User user = createUser();
        String jsonRequest = mapper.writeValueAsString(user);

        MvcResult createResult = this.mockMvc
                .perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void testRegisterFail() throws Exception {
        User user = createUser();
        UserDto userDto = userConverter.convertToUserDto(user);

        Assertions.assertThrows(NestedServletException.class, () ->this.mockMvc
                .perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(userDto)))
                .andExpect(content().string(containsString("Method argument validation failed"))));
    }

    /*@Test
    void testLoginSuccess() throws Exception {
        User user = createUser();
        Login request = new Login(user.getEmail(), user.getPassword());

        MvcResult createResult = this.mockMvc
                .perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(header().exists(HttpHeaders.AUTHORIZATION))
                .andReturn();

        //UserView authUserView = fromJson(objectMapper, createResult.getResponse().getContentAsString(), UserView.class);
        //assertEquals(userView.getId(), authUserView.getId(), "User ids must match!");
    }*/


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