package fr.esgi.rent_car.exception;

import fr.esgi.rent_car.model.User;
import org.springframework.http.HttpStatus;

import java.util.function.Consumer;

public class ConflictException extends ApiBaseException {

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
