package com.acv.randomuser.data.local.mapper;

import com.acv.randomuser.data.local.model.LoginLocalModel;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Login;


public class LoginLocalMapper implements TwoWaysMapper<LoginLocalModel, Login> {
    @Override
    public Login map(LoginLocalModel loginLocalModel) {
        if (loginLocalModel == null) {
            return null;
        }

        return new Login(
                loginLocalModel.getUsername(),
                loginLocalModel.getPassword(),
                loginLocalModel.getSalt(),
                loginLocalModel.getMd5(),
                loginLocalModel.getSha1(),
                loginLocalModel.getSha256()
        );
    }

    @Override
    public LoginLocalModel inverseMap(Login login) {
        if (login == null) {
            return null;
        }

        return new LoginLocalModel(
                login.getUsername(),
                login.getPassword(),
                login.getSalt(),
                login.getMd5(),
                login.getSha1(),
                login.getSha256()
        );

    }
}
