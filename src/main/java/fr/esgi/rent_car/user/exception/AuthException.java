package fr.esgi.rent_car.user.exception;


public class AuthException extends RuntimeException{
    public AuthException(String message) {
        super(message);
    }
}
