package com.acv.randomuser.ui;

import com.acv.randomuser.RandomUserStub;
import com.acv.randomuser.domain.GetRandomUsers;
import com.acv.randomuser.domain.UseCaseResponse;
import com.acv.randomuser.domain.model.RandomUser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

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
    private RandomUserMapper mapper;

    @Before
    public void setUp() {
        presenter = new MainPresenter(view, getRandomUsers, mapper);
    }

    @Test
    public void showRamdonUserWhenCallLoadRandomUsers() throws Exception {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsers(10);
        when(getRandomUsers.call()).thenReturn(new UseCaseResponse<>(randomUsers));

        presenter.loadRandomUsers();

        verify(view).showRandomUsers(mapper.map(randomUsers));
    }
}