package com.acv.randomuser;

import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.model.RandomUser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RandomUserRepositoryShould {

    private RandomUserRepository repository;

    @Mock
    private RandomUserNetwork network;

    @Before
    public void setUp() throws Exception {
        repository = new RandomUserRepository(network);
    }

    @Test
    public void obtainRandomUserFromNetwork() throws Exception {
        List<RandomUser> randomUsers = RandomUserStub.getRandomUsers(10);
        when(repository.getRandomUsers()).thenReturn(randomUsers);

        repository.getRandomUsers();

        verify(network).obtainAllRandomUsers();
    }

    public void assertion(RandomUser randomUser) {
        assertEquals(randomUser.getGender(), "1");
        assertEquals(randomUser.getName().getFirst(), "1");
        assertEquals(randomUser.getName().getLast(), "delectus aut autem");
        assertEquals(randomUser.getName().getTitle(), "delectus aut autem");
        assertEquals(randomUser.getLocation().getCity(), "delectus aut autem");
        assertEquals(randomUser.getLocation().getPostcode(), "delectus aut autem");
        assertEquals(randomUser.getLocation().getState(), "delectus aut autem");
        assertEquals(randomUser.getLocation().getStreet(), "delectus aut autem");
        assertEquals(randomUser.getEmail(), "1");
        assertEquals(randomUser.getLogin().getMd5(), "1");
        assertEquals(randomUser.getLogin().getPassword(), "1");
        assertEquals(randomUser.getLogin().getSalt(), "1");
        assertEquals(randomUser.getLogin().getSha1(), "1");
        assertEquals(randomUser.getLogin().getSha256(), "1");
        assertEquals(randomUser.getDob(), "1");
        assertEquals(randomUser.getRegistered(), "1");
        assertEquals(randomUser.getPhone(), "1");
        assertEquals(randomUser.getCell(), "1");
        assertEquals(randomUser.getId().getName(), "1");
        assertEquals(randomUser.getId().getValue(), "1");
        assertEquals(randomUser.getPicture().getLarge(), "1");
        assertEquals(randomUser.getPicture().getMedium(), "1");
        assertEquals(randomUser.getPicture().getThumbnail(), "1");
        assertEquals(randomUser.getNat(), "1");
    }

}