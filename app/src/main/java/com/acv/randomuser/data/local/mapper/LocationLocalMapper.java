package com.acv.randomuser.data.local.mapper;

import com.acv.randomuser.data.local.model.LocationLocalModel;
import com.acv.randomuser.domain.mapper.TwoWaysMapper;
import com.acv.randomuser.domain.model.Location;


public class LocationLocalMapper implements TwoWaysMapper<LocationLocalModel, Location> {
    @Override
    public Location map(LocationLocalModel locationLocalModel) {
        if (locationLocalModel == null) {
            return null;
        }

        return new Location(
                locationLocalModel.getStreet(),
                locationLocalModel.getCity(),
                locationLocalModel.getState(),
                locationLocalModel.getPostcode()
        );
    }

    @Override
    public LocationLocalModel inverseMap(Location location) {
        if (location == null) {
            return null;
        }

        return new LocationLocalModel(
                location.getStreet(),
                location.getCity(),
                location.getState(),
                location.getPostcode()
        );
    }
}
