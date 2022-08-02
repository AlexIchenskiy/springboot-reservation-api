package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Location;

import java.util.List;

public interface LocationService {

    Location save(Location location);
    List<Location> findAll();
    Location findById(Long id);
    Location update(Long id, Location locationDetails);
    void deleteById(Long id);

}
