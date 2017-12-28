package com.acv.randomuser.data;


import com.acv.randomuser.domain.error.LocalException;
import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public interface RandomUserDataSource {
    RandomUser get(Id key) throws LocalException;
    List<RandomUser> getAll() throws NetworkGatewayException, NetworkException;
    Boolean isUpdated();
    void populate(List<RandomUser> randomUsers);
    Boolean contains(Id key);
}
