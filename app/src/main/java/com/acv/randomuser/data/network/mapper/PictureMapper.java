package com.acv.randomuser.data.network.mapper;

import com.acv.randomuser.data.network.model.PictureDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Picture;


public class PictureMapper implements Mapper<PictureDataModel, Picture> {
    @Override
    public Picture map(PictureDataModel pictureDataModel) {
        if (pictureDataModel == null) {
            return null;
        }

        return new Picture(
                pictureDataModel.getLarge(),
                pictureDataModel.getMedium(),
                pictureDataModel.getThumbnail()
        );
    }
}
