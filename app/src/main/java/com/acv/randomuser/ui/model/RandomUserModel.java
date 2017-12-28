package com.acv.randomuser.ui.model;


public class RandomUserModel {
    private String fullName;
    private String city;
    private String picture;
    private String phone;

    public RandomUserModel(String fullName, String city, String picture, String phone) {
        this.fullName = fullName;
        this.city = city;
        this.picture = picture;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCity() {
        return city;
    }

    public String getPicture() {
        return picture;
    }

    public String getPhone() {
        return phone;
    }
}
