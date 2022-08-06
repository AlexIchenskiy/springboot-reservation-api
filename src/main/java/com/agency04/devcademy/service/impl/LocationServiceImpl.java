package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.exception.DuplicateLocationException;
import com.agency04.devcademy.exception.LocationNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.repository.LocationRepository;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    AccommodationService accommodationService;

    LocationRepository locationRepository;

    public LocationServiceImpl(@Qualifier("locationRepository") LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location save(Location location) {
        if (locationRepository.findAll().contains(location))
            throw new DuplicateLocationException();
        return locationRepository.save(location);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    @Override
    public Location update(Long id, Location locationDetails) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));

        location.setTitle(locationDetails.getTitle());
        location.setSubtitle(location.getSubtitle());
        location.setPostalCode(locationDetails.getPostalCode());

        return locationRepository.save(location);
    }

    @Override
    public void deleteById(Long id) {
        Location location = locationRepository.findById(id)
                .orElse(null);

        if (location == null)
            return;

        // delete all accommodations with this location
        for (Accommodation a : accommodationService.findAll()) {
            if (a.getLocation() == location) {
                accommodationService.deleteById(a.getId());
            }
        }

        locationRepository.deleteById(id);
    }

}
