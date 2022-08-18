package com.agency04.devcademy.converter;

import com.agency04.devcademy.form.LocationForm;
import com.agency04.devcademy.model.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationFormToLocation implements Converter<LocationForm, Location> {

    @Override
    public Location convert(LocationForm locationDetails) {
        final Location location = new Location();

        location.setTitle(locationDetails.getTitle());
        location.setSubtitle(locationDetails.getSubtitle());
        location.setPostalCode(locationDetails.getPostalCode());

        return location;
    }
}
