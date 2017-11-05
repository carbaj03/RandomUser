package com.acv.randomuser.data.network;


import com.acv.randomuser.data.network.model.IdDataModel;
import com.acv.randomuser.data.network.model.LocationDataModel;
import com.acv.randomuser.data.network.model.LoginDataModel;
import com.acv.randomuser.data.network.model.NameDataModel;
import com.acv.randomuser.data.network.model.PictureDataModel;
import com.google.gson.annotations.SerializedName;

public class RandomUserResult {
    @SerializedName("gender")
    private String gender;

    @SerializedName("name")
    private NameDataModel name;

    @SerializedName("location")
    private LocationDataModel location;

    @SerializedName("email")
    private String email;

    @SerializedName("login")
    private LoginDataModel login;

    @SerializedName("dob")
    private String dob;

    @SerializedName("registered")
    private String registered;

    @SerializedName("phone")
    private String phone;

    @SerializedName("cell")
    private String cell;

    @SerializedName("id")
    private IdDataModel id;

    @SerializedName("picture")
    private PictureDataModel picture;

    @SerializedName("nat")
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public NameDataModel getName() {
        return name;
    }

    public void setName(NameDataModel name) {
        this.name = name;
    }

    public LocationDataModel getLocation() {
        return location;
    }

    public void setLocation(LocationDataModel location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginDataModel getLogin() {
        return login;
    }

    public void setLogin(LoginDataModel login) {
        this.login = login;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public IdDataModel getId() {
        return id;
    }

    public void setId(IdDataModel id) {
        this.id = id;
    }

    public PictureDataModel getPicture() {
        return picture;
    }

    public void setPicture(PictureDataModel picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}
