package com.acv.randomuser.data.local.mapper;

import com.acv.randomuser.data.local.model.NameLocalModel;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Name;


public class NameLocalMapper implements TwoWaysMapper<NameLocalModel, Name> {

    @Override
    public Name map(NameLocalModel nameLocalModel) {
        if (nameLocalModel == null) {
            return null;
        }

        return new Name(
                nameLocalModel.getTitle(),
                nameLocalModel.getFirst(),
                nameLocalModel.getLast()
        );
    }

    @Override
    public NameLocalModel inverseMap(Name name) {
        if (name == null) {
            return null;
        }

        return new NameLocalModel(
                name.getTitle(),
                name.getFirst(),
                name.getLast()
        );
    }
}
