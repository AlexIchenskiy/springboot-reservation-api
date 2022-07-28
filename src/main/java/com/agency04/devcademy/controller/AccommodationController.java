package com.agency04.devcademy.controller;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccommodationController {

    private final AccommodationRepository accommodationRepository;

    public AccommodationController(@Qualifier("accommodationRepository") AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @GetMapping("/accommodations")
    public List<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }

    @PostMapping("/accommodations")
    public Accommodation add(@Valid @RequestBody Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @GetMapping("/accommodations/{id}")
    public Accommodation getById(@PathVariable(value = "id") Long id) {
        return accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }

    @PutMapping("/accommodations/{id}")
    public Accommodation update(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Accommodation accommodationDetails) throws AccommodationNotFoundException {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));

        accommodation.setTitle(accommodationDetails.getTitle());
        accommodation.setSubtitle(accommodationDetails.getSubtitle());
        accommodation.setDescription(accommodationDetails.getDescription());
        accommodation.setType(accommodationDetails.getType());
        accommodation.setCategorization(accommodationDetails.getCategorization());
        accommodation.setPersonCount(accommodationDetails.getPersonCount());
        accommodation.setImageUrl(accommodationDetails.getImageUrl());
        accommodation.setFreeCancelation(accommodationDetails.isFreeCancelation());
        accommodation.setPrice(accommodationDetails.getPrice());

        return accommodationRepository.save(accommodation);
    }

    @DeleteMapping("/accommodations/{id}")
    public void delete(@PathVariable Long id) {
        accommodationRepository.deleteById(id);
    }

}
