package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.LocationNotFoundException;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.LocationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(@Qualifier("locationServiceImpl") LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAll() {
        return new ResponseEntity<>(locationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Location> add(@Valid @RequestBody Location location) {
        return new ResponseEntity<>(locationService.save(location), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Location> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(locationService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Location> update(@PathVariable(value = "id") Long id,
                                                @Valid @RequestBody Location locationDetails) {
        return new ResponseEntity<>(locationService.update(id, locationDetails), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        locationService.deleteById(id);

        return new ResponseEntity<>("Location deleted", HttpStatus.OK);
    }

}
