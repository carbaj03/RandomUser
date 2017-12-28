package com.acv.randomuser.domain;

import android.support.annotation.NonNull;

import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.LocalException;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.detail.GetRandomUserDetail;
import com.acv.randomuser.domain.usecase.detail.GetRandomUserDetailError;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static com.acv.randomuser.RandomUserStub.ID;
import static com.acv.randomuser.RandomUserStub.RANDOM_USERS_DETAIL;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetRandomUserDetailShould {
    @Mock
    private RandomUserRepository repository;
    private GetRandomUserDetail getRandomUserDetail;


    @Before
    public void setUp() throws Exception {
        getRandomUserDetail = new GetRandomUserDetail(repository);
    }

    @Test
    public void returnGetRandomUserDetailErrorWhenThrowException() throws Exception {
        UseCaseResponse<RandomUser> response = getRandomUserDetail.call();

        Assert.assertTrue(response.hasError());
        Assert.assertTrue(response.getError().getClass().equals(GetRandomUserDetailError.class));
    }

    @Test
    public void returnGetRandomUserDetailErrorWhenModelIsEmpty() throws Exception {
        UseCaseResponse<RandomUser> response = getRandomUserDetail.call();

        Assert.assertTrue(response.hasError());
        Assert.assertTrue(response.getError().getClass().equals(GetRandomUserDetailError.class));
    }

    @Test
    public void returnDetailUserWhenLocalCallIsSuccess() throws Exception {
        RandomUser randomUsersDetail = getRandomUserDetail();

        UseCaseResponse<RandomUser> response = getRandomUserDetail.call();

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getResult().equals(randomUsersDetail));
    }

    @NonNull
    private RandomUser getRandomUserDetail() throws LocalGatewayException, LocalException {
        getRandomUserDetail.setId(ID);
        RandomUser randomUsersDetail = RANDOM_USERS_DETAIL;
        when(repository.obtainBy(ID)).thenReturn(randomUsersDetail);
        return randomUsersDetail;
    }
}