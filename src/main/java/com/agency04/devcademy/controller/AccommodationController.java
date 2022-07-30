package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationServiceImpl accommodationServiceImpl;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationServiceImpl accommodationServiceImpl) {
        this.accommodationServiceImpl = accommodationServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<Accommodation>> getAll() {
        return new ResponseEntity<>(accommodationServiceImpl.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Accommodation> add(@Valid @RequestBody Accommodation accommodation) {
        return new ResponseEntity<>(accommodationServiceImpl.save(accommodation), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accommodationServiceImpl.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Accommodation> update(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Accommodation accommodationDetails) throws AccommodationNotFoundException {
        return new ResponseEntity<>(accommodationServiceImpl.update(id, accommodationDetails), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accommodationServiceImpl.deleteById(id);

        return new ResponseEntity<>("Accommodation deleted", HttpStatus.OK);
    }

}
