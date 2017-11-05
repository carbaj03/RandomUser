package com.acv.randomuser.ui.model;


public class RandomUserModel {
    private String fullName;
    private String email;
    private String picture;
    private String phone;

    public RandomUserModel(String fullName, String email, String picture, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.picture = picture;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public String getPhone() {
        return phone;
    }
}
