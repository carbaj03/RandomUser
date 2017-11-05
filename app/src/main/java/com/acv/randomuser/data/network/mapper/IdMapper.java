package com.acv.randomuser.data.network.mapper;

import com.acv.randomuser.data.network.model.IdDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Id;


public class IdMapper implements Mapper<IdDataModel, Id> {
    @Override
    public Id map(IdDataModel idDataModel) {
        if (idDataModel == null) {
            return null;
        }

        return new Id(
                idDataModel.getName(),
                idDataModel.getValue()
        );
    }
}
