package com.acv.randomuser.domain;


import com.acv.randomuser.domain.error.NetworkException;
import com.acv.randomuser.domain.error.NetworkGatewayException;
import com.acv.randomuser.domain.model.RandomUser;

import java.util.List;

public interface RandomUserNetwork {
    List<RandomUser> obtainAllRandomUsers() throws NetworkException, NetworkGatewayException;
}
