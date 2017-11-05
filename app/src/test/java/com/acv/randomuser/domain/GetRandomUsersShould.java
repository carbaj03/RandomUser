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
    public void returnModelWhenNetworkGatewayIsCalled() throws Exception {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsers(2);
        when(repository.getRandomUsers()).thenReturn(randomUsers);

        UseCaseResponse<List<RandomUser>> response = getRandomUsers.call();

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getResult().equals(randomUsers));
    }

    @Test
    public void returnRandomUsersNotDuplicated() throws Exception {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsersDuplicated(5,2);
        when(repository.getRandomUsers()).thenReturn(randomUsers);

        UseCaseResponse<List<RandomUser>> response = getRandomUsers.call();

        Assert.assertTrue(response.getResult().size() == 5);
    }

    @Test
    public void returnRandomUsersNotDeletedYet() throws Exception {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsers(5);
        List<RandomUser> deleted = RandomUserStub.getRandomUsers(1);
        when(repository.obtainAllDeleted()).thenReturn(deleted);
        when(repository.getRandomUsers()).thenReturn(randomUsers);

        UseCaseResponse<List<RandomUser>> response = getRandomUsers.call();

        Assert.assertTrue(response.getResult().size() == 4);
    }
}