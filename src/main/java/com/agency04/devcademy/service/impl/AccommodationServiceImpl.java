package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.exception.AccommodationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Primary
public class AccommodationServiceImpl implements AccommodationService {

    private AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(@Qualifier("accommodationRepository") AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public AccommodationType getAccommodationType() {
        return null;
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
    public List<Accommodation> recommendation() {
        List<Accommodation> list = accommodationRepository.findAll();

        Collections.shuffle(list);

        return list.stream().limit(10).toList();
    }

    @Override
    public List<Accommodation> getAccommodationByLocationId(Long id) {
        return accommodationRepository.findByLocationId(id);
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
        accommodation.setImage(accommodationDetails.getImage());
        accommodation.setFreeCancelation(accommodationDetails.isFreeCancelation());
        accommodation.setPrice(accommodationDetails.getPrice());
        accommodation.setLocation(accommodationDetails.getLocation());

        return accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

}
