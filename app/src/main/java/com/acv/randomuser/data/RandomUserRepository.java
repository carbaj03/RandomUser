package com.acv.randomuser.data;


import com.acv.randomuser.domain.error.LocalException;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public class RandomUserRepository {

    private final List<RandomUserDataSource> dataSources;

    public RandomUserRepository(List<RandomUserDataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public List<RandomUser> getRandomUsers() throws NetworkGatewayException, NetworkException {
        List<RandomUser> all = null;
        for (RandomUserDataSource dataSource : dataSources) {
            if (dataSource.isUpdated()) {
                all = dataSource.getAll();
            }
        }

        if (all != null) {
            for (RandomUserDataSource dataSource : dataSources) {
                dataSource.populate(all);
            }
        }
        return all;
    }


    public RandomUser obtainBy(Id id) throws LocalException {
        RandomUser user = null;
        for (RandomUserDataSource dataSource : dataSources) {
            if (dataSource.contains(id)) {
                user = dataSource.get(id);
                return user;
            }
        }
        return user;
    }
}
