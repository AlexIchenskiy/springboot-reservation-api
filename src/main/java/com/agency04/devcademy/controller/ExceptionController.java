package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllExceptions(Exception e, WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(e.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse("Internal server error", details);

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccommodationNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleAccommodationNotFoundException(Exception e, WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(e.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse("Accommodation id does not exist", details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleLocationNotFoundException(Exception e, WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(e.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse("Location id does not exist", details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateLocationException.class)
    public final ResponseEntity<ErrorResponse> duplicateLocationException(Exception e, WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(e.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse("Location already exists", details);

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public final ResponseEntity<ErrorResponse> reservationNotFoundException(Exception e, WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(e.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse("Reservation id does not exist", details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsersNotFoundException.class)
    public final ResponseEntity<ErrorResponse> usersNotFoundException(Exception e, WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(e.getLocalizedMessage());

        ErrorResponse error = new ErrorResponse("User id does not exist", details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        List<String> details = new ArrayList<>();

        for (FieldError fe : e.getFieldErrors())
            details.add(fe.getField() + " -> " + fe.getDefaultMessage());

        ErrorResponse error = new ErrorResponse("Provided data is invalid", details);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
