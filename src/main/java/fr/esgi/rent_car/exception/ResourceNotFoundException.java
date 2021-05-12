package fr.esgi.rent_car.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiBaseException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
