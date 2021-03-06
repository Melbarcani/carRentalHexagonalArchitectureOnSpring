package fr.esgi.rent_car.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ApiBaseException.class})
    public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException e, WebRequest request) {
        var details = new ErrorDetails(e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(details, e.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        String uri = request.getDescription(false);

        var validationError = new ValidationError(uri);
        var fieldErrors = ex.getBindingResult().getFieldErrors();

        fieldErrors.forEach(f -> validationError.addError(f.getDefaultMessage()));

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
