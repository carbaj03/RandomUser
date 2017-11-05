package com.acv.randomuser.data.network;


import android.support.annotation.NonNull;

import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<RandomUser> getRandomUsers() throws IOException, NetworkGatewayException, NetworkException {
        Response<RandomUserResponse> response = apiClient.getAllRandomUsers().execute();
        if (response.isSuccessful()) {
            return getRandomUsers(response);
        } else if (isClientError(response)) {
            throw new NetworkGatewayException();
        } else {
            throw new NetworkException();
        }
    }

    private boolean isClientError(Response<RandomUserResponse> response) {
        return response.code() >= 400 && response.code() < 500;
    }

    @NonNull
    private List<RandomUser> getRandomUsers(Response<RandomUserResponse> response) {
        List<RandomUser> randomUsers = new ArrayList<>();
        HashMap<Id, RandomUser> random = new HashMap<>();
        List<RandomUserResult> results = response.body().getResults();
        if (results != null) {
            for (RandomUserResult result : results) {
                randomUsers.add(mapper.map(result));
            }
        }
        return randomUsers;
    }

//    @NonNull
//    private List<RandomUser> getRandomUsers(Response<RandomUserResponse> response) {
//        HashMap<Id, RandomUser> random = new HashMap<>();
//        List<RandomUserResult> results = response.body().getResults();
//        if (results != null) {
//            RandomUser map;
//            for (RandomUserResult result : results) {
//                map = mapper.map(result);
//                random.put(map.getId(), map);
//            }
//        }
//        return new ArrayList<>(random.values());
//    }
}
