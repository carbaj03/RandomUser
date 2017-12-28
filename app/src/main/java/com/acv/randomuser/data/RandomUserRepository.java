package com.acv.randomuser.data;


import com.acv.randomuser.data.local.LocalStorage;
import com.acv.randomuser.data.local.mapper.RandomDeleteUserLocalMapper;
import com.acv.randomuser.data.local.mapper.RandomUserLocalMapper;
import com.acv.randomuser.data.local.model.RandomDeleteUserLocalModel;
import com.acv.randomuser.data.local.model.RandomUserLocalModel;
import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public class RandomUserRepository {

    private final List<RandomUserDataSource> dataSources;
    private final RandomDeleteUserLocalMapper mapperDelete;
    private final RandomUserLocalMapper mapper;

    public RandomUserRepository(
            List<RandomUserDataSource> dataSources,
            RandomDeleteUserLocalMapper mapperDelete,
            RandomUserLocalMapper mapper
    ) {
        this.dataSources = dataSources;
        this.mapperDelete = mapperDelete;
        this.mapper = mapper;
    }

    public List<RandomUser> getRandomUsers() throws NetworkGatewayException, NetworkException {
        List<RandomUser> all = null;
        for (RandomUserDataSource dataSource : dataSources) {
            if(dataSource.isUpdated()){
                all = dataSource.getAll();
                dataSource.populate(all);
                return all;
            }
        }
        return all;
    }


}
