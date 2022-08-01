package com.agency04.devcademy.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:ara.properties")
@Component
public class OwnerDataSource {

    private String facebookUrl;
    private String instagramUrl;

    public OwnerDataSource(@Value("${accommodation.owner.facebook}") String facebookUrl,
                           @Value("${accommodation.owner.instagram}") String instagramUrl) {
        this.facebookUrl = facebookUrl;
        this.instagramUrl = instagramUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public void printOwnerData(String greeting) {
        System.out.println(greeting + ", your facebook and instagram are: " + facebookUrl + " and " + instagramUrl);
    }

}
