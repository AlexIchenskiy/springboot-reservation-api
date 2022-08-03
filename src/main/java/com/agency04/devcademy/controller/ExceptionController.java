package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.exception.DuplicateLocationException;
import com.agency04.devcademy.exception.LocationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
