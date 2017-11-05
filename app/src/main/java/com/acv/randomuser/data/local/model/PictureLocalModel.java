package com.acv.randomuser.data.local.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PictureLocalModel extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String large;
    private String medium;
    private String thumbnail;

    public PictureLocalModel() {
    }

    public PictureLocalModel(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}