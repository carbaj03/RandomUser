package com.acv.randomuser.data.network;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("/?results=40")
    Call<RandomUserResponse> getAllRandomUsers();
}
