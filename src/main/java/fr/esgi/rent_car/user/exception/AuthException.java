package fr.esgi.rent_car.user.exception;

import org.springframework.http.HttpStatus;

public class AuthException extends RuntimeException{
    public AuthException(String message) {
        super(message);
    }
}
