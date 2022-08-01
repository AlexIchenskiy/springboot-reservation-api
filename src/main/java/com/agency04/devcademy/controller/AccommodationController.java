package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.AccommodationServiceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationServiceFactory accommodationServiceFactory;

    public AccommodationController(@Qualifier("accommodationServiceFactory") AccommodationServiceFactory accommodationServiceFactory) {
        this.accommodationServiceFactory = accommodationServiceFactory;
    }

    @GetMapping()
    public ResponseEntity<List<Accommodation>> getAll() {
        return new ResponseEntity<>(accommodationServiceFactory.getAccommodationService().findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Accommodation> add(@Valid @RequestBody Accommodation accommodation) {
        return new ResponseEntity<>(accommodationServiceFactory
                .getAccommodationService(accommodation.getType()).save(accommodation), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accommodationServiceFactory.getAccommodationService().findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Accommodation> update(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Accommodation accommodationDetails) throws AccommodationNotFoundException {
        return new ResponseEntity<>(accommodationServiceFactory
                .getAccommodationService(accommodationDetails.getType()).update(id, accommodationDetails), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accommodationServiceFactory.getAccommodationService().deleteById(id);

        return new ResponseEntity<>("Accommodation deleted", HttpStatus.OK);
    }

}
