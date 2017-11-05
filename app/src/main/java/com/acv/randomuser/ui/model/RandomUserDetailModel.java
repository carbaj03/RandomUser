package com.acv.randomuser.ui.model;

/**
 * Created by alejandro on 14/06/17.
 */

public class RandomUserDetailModel {
    private String fullName;
    private String email;
    private String thumbPicture;
    private String gender;
    private String registerDate;
    private String fullLocation;

    public RandomUserDetailModel(String fullName, String email, String picture,
                                 String gender, String registerDate, String location) {
        this.fullName = fullName;
        this.email = email;
        this.thumbPicture = picture;
        this.gender = gender;
        this.registerDate = registerDate;
        this.fullLocation = location;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getThumbPicture() {
        return thumbPicture;
    }

    public String getGender() {
        return gender;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getFullLocation() {
        return fullLocation;
    }
}
