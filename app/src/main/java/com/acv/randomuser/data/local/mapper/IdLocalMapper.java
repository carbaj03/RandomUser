package com.acv.randomuser.data.local.mapper;

import com.acv.randomuser.data.local.model.IdLocalModel;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Id;


public class IdLocalMapper implements TwoWaysMapper<IdLocalModel, Id> {
    @Override
    public Id map(IdLocalModel idLocalModel) {
        if (idLocalModel == null) {
            return null;
        }

        return new Id(
                idLocalModel.getName(),
                idLocalModel.getValue()
        );
    }

    @Override
    public IdLocalModel inverseMap(Id id) {
        if (id == null) {
            return null;
        }

        return new IdLocalModel(
                id.getName(),
                id.getValue()
        );
    }
}
