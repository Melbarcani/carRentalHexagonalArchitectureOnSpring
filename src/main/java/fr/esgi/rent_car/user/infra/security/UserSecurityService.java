package fr.esgi.rent_car.user.infra.security;

import fr.esgi.rent_car.exception.ResourceNotFoundException;
import fr.esgi.rent_car.user.infra.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@AllArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var appUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format("This email :  {0} not found", email)));

        return org.springframework.security.core.userdetails.User.builder()
                .username(email)
                .password(appUser.getPassword())
                .roles(appUser.getRole().toString())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
