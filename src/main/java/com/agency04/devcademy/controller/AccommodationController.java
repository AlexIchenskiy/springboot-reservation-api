package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(@Qualifier("accommodationService") AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping()
    public List<Accommodation> getAll() {
        return accommodationService.findAll();
    }

    @PostMapping()
    public Accommodation add(@Valid @RequestBody Accommodation accommodation) {
        return accommodationService.save(accommodation);
    }

    @GetMapping("{id}")
    public Accommodation getById(@PathVariable(value = "id") Long id) {
        return accommodationService.findById(id);
    }

    @PutMapping("{id}")
    public Accommodation update(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Accommodation accommodationDetails) throws AccommodationNotFoundException {
        return accommodationService.update(id, accommodationDetails);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        accommodationService.deleteById(id);
    }

}
