package com.acv.randomuser.api;

import android.support.annotation.NonNull;

import com.acv.randomuser.data.network.NetworkDataSource;
import com.acv.randomuser.data.network.ApiClient;
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

public class RandomUserRetrofitShould extends MockWebServerTest {

    private TestNetworkModule networkModule;
    private NetworkDataSource gateway;

    public RandomUserRetrofitShould() {
        this.networkModule = new TestNetworkModule();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        gateway = new NetworkDataSource(networkModule.getApiClient(getServer()), getMapper());
    }

    @Test
    public void shouldSendsGetAllRandomUserRequestToTheCorrectEndpoint() throws Exception {
        enqueueMockResponse(200, "getAllRandomUserResponse.json");

        gateway.getAll();

        assertGetRequestSentTo("/?results=40");
    }

    @Test(expected = NetworkGatewayException.class)
    public void throwsUnknownErrorExceptionIfThereIsNotHandledErrorGettingAllTasks()
            throws Exception {
        enqueueMockResponse(403);

        gateway.getAll();
    }

    @Test(expected = NetworkException.class)
    public void throwsExceptionWhenWithoutInternetConnection() throws Exception {
        ApiClient apiClient = Mockito.mock(ApiClient.class);
        when(apiClient.getAllRandomUsers()).thenThrow(UnknownHostException.class);

        NetworkDataSource apiGateway = new NetworkDataSource(apiClient, getMapper());

        apiGateway.getAll();
    }

    @Test(expected = NetworkGatewayException.class)
    public void throwsNetworkGatewayExceptionWhenInternalServerError() throws Exception {
        enqueueMockResponse(500);

        gateway.getAll();
    }

    @Test(expected = NetworkException.class)
    public void throwsNetworkExceptionWhenTimeOut() throws Exception {
        enqueueMockResponse(SocketPolicy.NO_RESPONSE);

        gateway.getAll();
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