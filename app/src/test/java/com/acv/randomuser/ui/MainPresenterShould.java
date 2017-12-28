package com.acv.randomuser.ui;

import com.acv.randomuser.RandomUserStub;
import com.acv.randomuser.domain.usecase.UseCaseResponse;
import com.acv.randomuser.domain.usecase.main.GetRandomUsers;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.main.SaveRandomUser;
import com.acv.randomuser.ui.main.MainPresenter;
import com.acv.randomuser.ui.main.MainView;
import com.acv.randomuser.ui.model.RandomUserMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterShould {
    private MainPresenter presenter;
    @Mock
    private MainView view;
    @Mock
    private GetRandomUsers getRandomUsers;
    @Mock
    private DeleteRandomUser deleteRandomUser;
    @Mock
    private SaveRandomUser saveRandomUser;
    @Mock
    private RandomUserMapper mapper;

    @Before
    public void setUp() {
        presenter = new MainPresenter(new FakeViewInjector(), TestUseCaseInvoker.create(),
                view, getRandomUsers, deleteRandomUser, saveRandomUser, mapper);
    }

    @Test
    public void showRamdonUserWhenCallLoadRandomUsers() throws Exception {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsers(10);
        when(getRandomUsers.call()).thenReturn(new UseCaseResponse<>(randomUsers));

        presenter.loadRandomUsers();

        verify(view).showRandomUsers(mapper.map(randomUsers));
    }

    @Test
    public void showErrorWhenIsGetRandomUserCaseError() throws Exception {
        when(getRandomUsers.call()).thenReturn(ResponseStub.ERROR_RESPONSE);

        presenter.loadRandomUsers();

        verify(view, times(1)).showError();
    }

    @Test
    public void showErrorNetworkWhenIsNetworkUserCaseError() throws Exception {
        when(getRandomUsers.call()).thenReturn(ResponseStub.ERROR_NET_RESPONSE);

        presenter.loadRandomUsers();

        verify(view, times(1)).showErrorNetwork();
    }
}