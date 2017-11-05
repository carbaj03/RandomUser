package com.acv.randomuser.data.network;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomUserResponse {
    @SerializedName("results")
    private List<RandomUserResult> results = null;

    public List<RandomUserResult> getResults() {
        return results;
    }

    public void setResults(List<RandomUserResult> results) {
        this.results = results;
    }
}
