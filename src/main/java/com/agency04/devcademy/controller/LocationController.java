package com.agency04.devcademy.controller;

import com.agency04.devcademy.DTO.LocationDTO;
import com.agency04.devcademy.converter.LocationFormToLocation;
import com.agency04.devcademy.form.LocationForm;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final LocationService locationService;

    private final LocationFormToLocation formToLocation = new LocationFormToLocation();

    public LocationController(@Qualifier("locationServiceImpl") LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAll() {
        return new ResponseEntity<>(locationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocationDTO> add(@Valid @RequestBody LocationForm locationForm) {
        return new ResponseEntity<>(modelMapper.map(locationService.save(formToLocation.convert(locationForm)),
                LocationDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Location> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(locationService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<LocationDTO> update(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody LocationForm locationDetails) {
        return new ResponseEntity<>(modelMapper.map(locationService.update(id,
                formToLocation.convert(locationDetails)), LocationDTO.class), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        locationService.deleteById(id);

        return new ResponseEntity<>("Location deleted", HttpStatus.OK);
    }

}
