package com.acv.randomuser.data;


import com.acv.randomuser.domain.error.LocalException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MemoryDataSource implements RandomUserDataSource{

    private TimeProvider timeProvider;

    private Long TIME_UPDATE = TimeUnit.SECONDS.toMillis(1);

    private LinkedHashMap cache = new LinkedHashMap<String, RandomUser>();
    private Long lastUpdate = 0L;

    public MemoryDataSource(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public RandomUser get(Id key) throws LocalException {
        RandomUser user = (RandomUser) cache.get(key);
        if (user == null)
            throw new LocalException();
        return user;
    }

    @Override
    public List<RandomUser> getAll() {
        return (List<RandomUser>) cache.values();
    }

    @Override
    public Boolean isUpdated() {
        return timeProvider.time() - lastUpdate < TIME_UPDATE;
    }

    @Override
    public void populate(List<RandomUser> randomUsers) {
        lastUpdate = timeProvider.time();
        for (RandomUser randomUser : randomUsers) {
            cache.put(randomUser.getId(), randomUser);
        }
    }

    @Override
    public Boolean contains(Id key) {
        return cache.containsKey(key);
    }
}
