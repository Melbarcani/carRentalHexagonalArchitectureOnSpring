package fr.esgi.rent_car.user.service;

import fr.esgi.rent_car.exception.ConflictException;
import fr.esgi.rent_car.user.domain.model.Login;
import fr.esgi.rent_car.model.Session;
import fr.esgi.rent_car.repository.SessionRepository;
import fr.esgi.rent_car.user.infra.security.TokenProvider;
import fr.esgi.rent_car.user.domain.model.User;
import fr.esgi.rent_car.user.infra.UserConverter;
import fr.esgi.rent_car.user.infra.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@AllArgsConstructor
@Service
public class AuthService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;
    private final SessionService sessionService;

    public HttpHeaders createSession(Login login) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getEmail(), login.getPassword()
        );
        var authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        var token = tokenProvider.createToken(authentication);

        var user = userRepository.findByEmail(login.getEmail());
        if (user.isPresent()) {
            sessionRepository.save(new Session(user.get().getId(), null, token, user.get()));
            sessionService.setCurrentUser(userConverter.convertToUser(user.get()));
        } else {
            throw new ResolutionException("there is no user registered with this email : " + login.getEmail());
        }

        var httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return httpHeaders;
    }

    public URI registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var existentUser = userRepository.findByEmail(user.getEmail());
        if (existentUser.isEmpty()) {
            var savedUser = userRepository.save(userConverter.convertToUserEntity(user));
            return fromPath("/api/users/").path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        } else {
            throw new ConflictException("this email : " + user.getEmail() + " is used by an other user");
        }
    }


}
