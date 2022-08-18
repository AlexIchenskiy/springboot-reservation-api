package com.agency04.devcademy.controller;

import com.agency04.devcademy.DTO.AccommodationDTO;
import com.agency04.devcademy.converter.AccommodationFormToAccommodation;
import com.agency04.devcademy.form.AccommodationForm;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.impl.AccommodationServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final AccommodationServiceImpl accommodationService;

    @Autowired
    private AccommodationFormToAccommodation formToAccommodation;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationServiceImpl accommodationService) {
        this.accommodationService = accommodationService;

        System.out.println("Controller initialized\n");
    }

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAll() {
        return new ResponseEntity<>(accommodationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccommodationDTO> add(@Valid @RequestBody AccommodationForm accommodationForm) {
        return new ResponseEntity<>(modelMapper.map(accommodationService.save(formToAccommodation.convert(accommodationForm)),
                AccommodationDTO.class), HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Accommodation> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accommodationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("{id}/image")
    public ResponseEntity<File> getImageById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accommodationService.findById(id).getImage(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/recommendation")
    public ResponseEntity<List<Accommodation>> recommendation() {
        return new ResponseEntity<>(accommodationService.recommendation(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/location")
    public ResponseEntity<List<Accommodation>> getAccommodationsByLocationId(@RequestParam Long locationId) {
        return new ResponseEntity<>(accommodationService.getAccommodationByLocationId(locationId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<AccommodationDTO> update(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody AccommodationForm accommodationDetails) {
        return new ResponseEntity<>(modelMapper.map(accommodationService.update(id,
                formToAccommodation.convert(accommodationDetails)), AccommodationDTO.class), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accommodationService.deleteById(id);

        return new ResponseEntity<>("Accommodation deleted", HttpStatus.OK);
    }

}
