package me.rogal.fibonacci.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ServletRequestBindingException.class)
    public final ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex, "Bad Request");
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
    {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex, "Server Error");
    }

    ResponseEntity buildResponse(HttpStatus status, Exception ex, String message) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = ErrorResponse.builder()
                .message(message)
                .details(details)
                .build();
        return new ResponseEntity(error, status);
    }
}
