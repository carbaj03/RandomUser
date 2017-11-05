package com.acv.randomuser.domain.model;

public class RandomUser {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String dob;
    private String registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
    private String nat;

    public RandomUser() {
    }

    public RandomUser(String gender, Name name, Location location, String email, Login login,
                      String dob, String registered, String phone, String cell, Id id,
                      Picture picture, String nat) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.id = id;
        this.picture = picture;
        this.nat = nat;
    }

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
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

    public Id getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }

    public String getFullname() {
        return name.getFirst() + " " + name.getLast();
    }

    public String getThumbPicture() {
        return picture.getThumbnail();
    }

    public String getFullLocation() {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getCity());
        sb.append(", ");
        sb.append(location.getCity());
        sb.append(", ");
        sb.append(location.getState());
        return sb.toString();
    }
}