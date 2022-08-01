package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class RoomAccommodationService implements AccommodationService {

    private AccommodationRepository accommodationRepository;

    public RoomAccommodationService(@Qualifier("accommodationRepository") AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.ROOM;
    }

    @Override
    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository.findById(id)
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }

    @Override
    public Accommodation update(Long id, Accommodation accommodationDetails) {
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

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

}
