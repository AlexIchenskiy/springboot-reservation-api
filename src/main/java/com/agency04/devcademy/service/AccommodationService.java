package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.AccommodationType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AccommodationService {

    AccommodationType getAccommodationType();
    Accommodation save(Accommodation accommodation);
    List<Accommodation> findAll();
    List<Accommodation> recommendation();
    List<Accommodation> getAccommodationByLocationId(Long id);
    Accommodation findById(Long id);
    Accommodation update(Long id, Accommodation accommodationDetails);
    Accommodation updateImage(Long id, MultipartFile multipartFile) throws IOException;
    void deleteById(Long id);

}
