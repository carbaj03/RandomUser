package com.acv.randomuser.data.local.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RandomDeleteUserLocalModel extends RealmObject {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String gender;
    private NameLocalModel name;
    private LocationLocalModel location;
    private String email;
    private LoginLocalModel login;
    private String dob;
    private String registered;
    private String phone;
    private String cell;
    private IdLocalModel idmodel;
    private PictureLocalModel picture;
    private String nat;

    public RandomDeleteUserLocalModel() {
    }

    public RandomDeleteUserLocalModel(String gender, NameLocalModel name, LocationLocalModel location, String email,
                                      LoginLocalModel login, String dob, String registered, String phone, String cell,
                                      IdLocalModel id, PictureLocalModel picture, String nat) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.idmodel = id;
        this.picture = picture;
        this.nat = nat;
    }

    public String getGender() {
        return gender;
    }

    public NameLocalModel getName() {
        return name;
    }

    public LocationLocalModel getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public LoginLocalModel getLogin() {
        return login;
    }

    public String getDob() {
        return dob;
    }

    public String getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public IdLocalModel getId() {
        return idmodel;
    }

    public PictureLocalModel getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }
}