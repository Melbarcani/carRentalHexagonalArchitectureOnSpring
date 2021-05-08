package fr.esgi.rent_car.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException{
    ApiBaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
