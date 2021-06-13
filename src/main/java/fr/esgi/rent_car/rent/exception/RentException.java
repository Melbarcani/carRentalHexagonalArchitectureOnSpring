package fr.esgi.rent_car.rent.exception;

import fr.esgi.rent_car.exception.ApiBaseException;
import org.springframework.http.HttpStatus;

public class RentException extends ApiBaseException {

    public RentException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_ACCEPTABLE;
    }
}
