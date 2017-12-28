package com.acv.randomuser.domain;

import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.main.DeleteRandomUserError;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.acv.randomuser.RandomUserStub.RANDOM_USERS;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class DeleteRandomUserShould {
    @Mock
    private RandomUserRepository repository;
    private DeleteRandomUser deleteRandomUser;


    @Before
    public void setUp() throws Exception {
        deleteRandomUser = new DeleteRandomUser(repository);
    }

    @Test
    public void returnDeleteUseCaseErrorWhenThrowException() throws Exception {
        doThrow(LocalGatewayException.class).when(repository).persistDeleteRandomUserModel(RANDOM_USERS);

        UseCaseResponse<Boolean> response = deleteRandomUser.call();

        Assert.assertTrue(response.hasError());
        Assert.assertTrue(response.getError().getClass().equals(DeleteRandomUserError.class));
    }


}