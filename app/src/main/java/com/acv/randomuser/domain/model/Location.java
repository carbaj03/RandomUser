package com.acv.randomuser.domain.model;

public class Location {
    private String street;
    private String city;
    private String state;
    private String postcode;

    public Location(String street, String city, String state, String postcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }
}