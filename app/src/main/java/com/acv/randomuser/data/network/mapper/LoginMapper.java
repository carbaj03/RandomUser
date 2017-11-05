package com.acv.randomuser.data.network.mapper;

import com.acv.randomuser.data.network.model.LoginDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Login;


public class LoginMapper implements Mapper<LoginDataModel, Login> {
    @Override
    public Login map(LoginDataModel loginDataModel) {
        if (loginDataModel == null) {
            return null;
        }

        return new Login(
                loginDataModel.getUsername(),
                loginDataModel.getPassword(),
                loginDataModel.getSalt(),
                loginDataModel.getMd5(),
                loginDataModel.getSha1(),
                loginDataModel.getSha256()
        );
    }
}
