package com.acv.randomuser.domain;

import com.acv.randomuser.RandomUserRepository;
import com.acv.randomuser.RandomUserStub;
import com.acv.randomuser.ui.RandomUserModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GetRandomUsersTest {
    private GetRandomUsers getRandomUsers;

    @Mock
    RandomUserRepository repository;

    @Before
    public void setUp() throws Exception {
        getRandomUsers = new GetRandomUsers(repository);
    }

    @Test
    public void shouldReturnModelWhenNetworkGatewayIsCalled() {
        List<RandomUserModel> randomUsers = RandomUserStub.getRandomUsers(10);
        when(repository.getRandomUsers(10)).thenReturn(randomUsers);

        UseCaseResponse<List<RandomUserModel>> response = getRandomUsers.call();

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getResult().equals(randomUsers));
    }
}