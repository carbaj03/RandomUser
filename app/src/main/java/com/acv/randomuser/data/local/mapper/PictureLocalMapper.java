package com.acv.randomuser.data.local.mapper;

import com.acv.randomuser.data.local.model.PictureLocalModel;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Picture;


public class PictureLocalMapper implements TwoWaysMapper<PictureLocalModel, Picture> {

    @Override
    public Picture map(PictureLocalModel pictureLocalModel) {
        if (pictureLocalModel == null) {
            return null;
        }

        return new Picture(
                pictureLocalModel.getLarge(),
                pictureLocalModel.getMedium(),
                pictureLocalModel.getThumbnail()
        );
    }

    @Override
    public PictureLocalModel inverseMap(Picture picture) {
        if (picture == null) {
            return null;
        }

        return new PictureLocalModel(
                picture.getLarge(),
                picture.getMedium(),
                picture.getThumbnail()
        );

    }
}
