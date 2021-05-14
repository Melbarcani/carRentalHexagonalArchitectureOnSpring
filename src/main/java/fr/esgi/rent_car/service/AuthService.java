package fr.esgi.rent_car.service;

import fr.esgi.rent_car.exception.ConflictException;
import fr.esgi.rent_car.model.Login;
import fr.esgi.rent_car.model.Session;
import fr.esgi.rent_car.model.Utilisateurs;
import fr.esgi.rent_car.repository.SessionRepository;
import fr.esgi.rent_car.repository.UserRepository;
import fr.esgi.rent_car.security.TokenProvider;
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

    public HttpHeaders createSession(Login login) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getEmail(), login.getPassword()
        );
        var authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        var token = tokenProvider.createToken(authentication);

        var user = userRepository.findByEmail(login.getEmail());
        if (user.isPresent()) {
            sessionRepository.save(new Session(user.get().getId(), null, token, user.get()));
        } else {
            throw new ResolutionException("there is no user registered with this email : " + login.getEmail());
        }

        var httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return httpHeaders;
    }

    public URI registerUser(Utilisateurs user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var existentUser = userRepository.findByEmail(user.getEmail());
        if (existentUser.isEmpty()) {
            var savedUser = userRepository.save(user);
            return fromPath("/api/users/").path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        } else {
            throw new ConflictException("this email : " + user.getEmail() + " is used by an other user");
        }
    }


}
