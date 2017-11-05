package com.acv.randomuser.data.network;


import android.support.annotation.NonNull;

import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.RandomUser;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RandomUserRetrofit implements RandomUserNetwork {
    private final ApiClient apiClient;
    private final Mapper<RandomUserResult, RandomUser> mapper;

    public RandomUserRetrofit(
            ApiClient apiClient,
            Mapper<RandomUserResult, RandomUser> mapper
    ) {
        this.apiClient = apiClient;
        this.mapper = mapper;
    }

    @Override
    public List<RandomUser> obtainAllRandomUsers() throws NetworkException, NetworkGatewayException {
        try {
            return getRandomUsers();
        } catch (UnknownHostException | ConnectException | SocketTimeoutException e) {
            throw new NetworkException();
        } catch (NetworkGatewayException e) {
            throw e;
        } catch (Exception e) {
            throw new NetworkGatewayException();
        }
    }

    @NonNull
    private List<RandomUser> getRandomUsers() throws IOException, NetworkGatewayException {
        Call<RandomUserResponse> call = apiClient.getAllRandomUsers();
        Response<RandomUserResponse> response = call.execute();
        if (response.isSuccessful()) {
            return getRandomUsers(response);
        } else if (response.code() >= 400 && response.code() < 500) {
            throw new NetworkGatewayException();
        } else {
            throw new NetworkException();
        }
    }

    @NonNull
    private List<RandomUser> getRandomUsers(Response<RandomUserResponse> response) {
        List<RandomUserResult> results = response.body().getResults();
        List<RandomUser> randomUsers = new ArrayList<>();
        if (results != null) {
            for (RandomUserResult result : results) {
                randomUsers.add(mapper.map(result));
            }
        }
        return randomUsers;
    }
}
