package com.acv.randomuser.data.network.mapper;

import com.acv.randomuser.data.network.model.NameDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Name;


public class NameMapper implements Mapper<NameDataModel, Name> {
    @Override
    public Name map(NameDataModel nameDataModel) {
        if (nameDataModel == null) {
            return null;
        }

        return new Name(
                nameDataModel.getTitle(),
                nameDataModel.getFirst(),
                nameDataModel.getLast()
        );
    }
}
