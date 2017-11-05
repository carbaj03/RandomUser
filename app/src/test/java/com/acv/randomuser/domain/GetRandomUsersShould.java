package com.acv.randomuser.domain;

import com.acv.randomuser.RandomUserStub;
import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.main.GetRandomUsers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GetRandomUsersShould {
    private GetRandomUsers getRandomUsers;

    @Mock
    RandomUserRepository repository;

    @Before
    public void setUp() throws Exception {
        getRandomUsers = new GetRandomUsers(repository);
    }

    @Test
    public void shouldReturnModelWhenNetworkGatewayIsCalled() {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsers(10);
        when(repository.getRandomUsers(10)).thenReturn(randomUsers);

        UseCaseResponse<List<RandomUser>> response = getRandomUsers.call();

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getResult().equals(randomUsers));
    }
}