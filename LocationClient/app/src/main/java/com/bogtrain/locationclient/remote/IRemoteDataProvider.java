package com.bogtrain.locationclient.remote;

import com.bogtrain.locationclient.model.MapPoint;

import java.util.List;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public interface IRemoteDataProvider {
    List<MapPoint> getCurrentPoints();
}
