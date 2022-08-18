package com.agency04.devcademy.converter;

import com.agency04.devcademy.form.AccommodationForm;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.LocationRepository;
import com.agency04.devcademy.service.impl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccommodationFormToAccommodation implements Converter<AccommodationForm, Accommodation> {

    @Autowired
    private LocationServiceImpl locationService;

    @Override
    public Accommodation convert(AccommodationForm accommodationDetails) {
        final Accommodation accommodation = new Accommodation();

        accommodation.setTitle(accommodationDetails.getTitle());
        accommodation.setSubtitle(accommodationDetails.getSubtitle());
        accommodation.setDescription(accommodationDetails.getDescription());
        accommodation.setType(accommodationDetails.getType());
        accommodation.setCategorization(accommodationDetails.getCategorization());
        accommodation.setPersonCount(accommodationDetails.getPersonCount());
        accommodation.setImage(accommodationDetails.getImage());
        accommodation.setFreeCancelation(accommodationDetails.isFreeCancelation());
        accommodation.setPrice(accommodationDetails.getPrice());
        accommodation.setLocation(locationService.findById(accommodationDetails.getLocationId()));

        return accommodation;
    }
}
