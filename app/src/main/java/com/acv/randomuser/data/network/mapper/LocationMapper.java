package com.acv.randomuser.data.network.mapper;

import com.acv.randomuser.data.network.model.LocationDataModel;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.Location;


public class LocationMapper implements Mapper<LocationDataModel, Location> {
    @Override
    public Location map(LocationDataModel locationDataModel) {
        if (locationDataModel == null) {
            return null;
        }

        return new Location(
                locationDataModel.getStreet(),
                locationDataModel.getCity(),
                locationDataModel.getState(),
                locationDataModel.getPostcode()
        );
    }
}
