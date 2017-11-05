package com.acv.randomuser.api;

import android.support.annotation.NonNull;


import com.acv.randomuser.data.network.ApiClient;
import com.acv.randomuser.data.network.RandomUserRetrofit;
import com.acv.randomuser.data.network.mapper.IdMapper;
import com.acv.randomuser.data.network.mapper.LocationMapper;
import com.acv.randomuser.data.network.mapper.LoginMapper;
import com.acv.randomuser.data.network.mapper.NameMapper;
import com.acv.randomuser.data.network.mapper.PictureMapper;
import com.acv.randomuser.data.network.mapper.UserMapper;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.UnknownHostException;

import okhttp3.mockwebserver.SocketPolicy;

import static org.mockito.Mockito.when;

public class RandomUserRetrofitTest extends MockWebServerTest {

    private TestNetworkModule networkModule;
    private RandomUserRetrofit gateway;

    public RandomUserRetrofitTest() {
        this.networkModule = new TestNetworkModule();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        gateway = new RandomUserRetrofit(networkModule.getApiClient(getServer()), getMapper());
    }

    @Test
    public void shouldSendsGetAllRandomUserRequestToTheCorrectEndpoint() throws Exception {
        enqueueMockResponse(200, "getAllRandomUserResponse.json");

        gateway.obtainAllRandomUsers();

        assertGetRequestSentTo("/?results=40");
    }

    @Test(expected = NetworkGatewayException.class)
    public void throwsUnknownErrorExceptionIfThereIsNotHandledErrorGettingAllTasks()
            throws Exception {
        enqueueMockResponse(403);

        gateway.obtainAllRandomUsers();
    }

    @Test(expected = NetworkException.class)
    public void throwsExceptionWhenWithoutInternetConnection() throws Exception {
        ApiClient apiClient = Mockito.mock(ApiClient.class);
        when(apiClient.getAllRandomUsers()).thenThrow(UnknownHostException.class);

        RandomUserRetrofit apiGateway = new RandomUserRetrofit(apiClient, getMapper());

        apiGateway.obtainAllRandomUsers();
    }

    @Test(expected = NetworkGatewayException.class)
    public void throwsNetworkGatewayExceptionWhenInternalServerError() throws Exception {
        enqueueMockResponse(500);

        gateway.obtainAllRandomUsers();
    }

    @Test(expected = NetworkException.class)
    public void shouldNetworkExceptionWhenTimeOut() throws Exception {
        enqueueMockResponse(SocketPolicy.NO_RESPONSE);

        gateway.obtainAllRandomUsers();
    }


    @NonNull
    private UserMapper getMapper() {
        return new UserMapper(
                new NameMapper(),
                new LocationMapper(),
                new PictureMapper(),
                new LoginMapper(),
                new IdMapper());
    }
}