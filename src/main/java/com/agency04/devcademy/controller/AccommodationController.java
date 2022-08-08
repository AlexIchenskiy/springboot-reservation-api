package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationServiceImpl accommodationService;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationServiceImpl accommodationService) {
        this.accommodationService = accommodationService;

        System.out.println("Controller initialized\n");
    }

    @GetMapping()
    public ResponseEntity<List<Accommodation>> getAll() {
        return new ResponseEntity<>(accommodationService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Accommodation> add(@Valid @RequestBody Accommodation accommodation) {
        return new ResponseEntity<>(accommodationService.save(accommodation), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accommodationService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/recommendation")
    public ResponseEntity<List<Accommodation>> recommendation() {
        List<Accommodation> list = accommodationService.findAll();

        if (list.size() == 0) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }

        Collections.shuffle(list);

        list = list.stream().limit(10).toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/location")
    public ResponseEntity<List<Accommodation>> getAccommodationsByLocationId(@RequestParam Long locationId) {
        List<Accommodation> list = accommodationService.findAll().stream()
                .filter((a) -> a.getLocation().getId().equals(locationId)).toList();

        if (list.size() == 0) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Accommodation> update(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Accommodation accommodationDetails) throws AccommodationNotFoundException {
        return new ResponseEntity<>(accommodationService.update(id, accommodationDetails), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accommodationService.deleteById(id);

        return new ResponseEntity<>("Accommodation deleted", HttpStatus.OK);
    }

}
