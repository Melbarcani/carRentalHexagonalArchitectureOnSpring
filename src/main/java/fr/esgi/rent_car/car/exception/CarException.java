package fr.esgi.rent_car.car.exception;

import fr.esgi.rent_car.exception.ApiBaseException;
import org.springframework.http.HttpStatus;

public class CarException extends ApiBaseException {
    public CarException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return null;
    }
}
