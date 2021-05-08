package fr.esgi.rent_car.security;

import fr.esgi.rent_car.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    private static final String[] PUBLIC_ENDPOINTS = {
            "/api/auth/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/users/**").hasRole(Role.USER.toString())
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

}
