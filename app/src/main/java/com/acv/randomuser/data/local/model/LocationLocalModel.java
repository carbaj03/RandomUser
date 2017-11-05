package com.acv.randomuser.data.local.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LocationLocalModel extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String street;
    private String city;
    private String state;
    private String postcode;

    public LocationLocalModel() {
    }

    public LocationLocalModel(String street, String city, String state, String postcode) {
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