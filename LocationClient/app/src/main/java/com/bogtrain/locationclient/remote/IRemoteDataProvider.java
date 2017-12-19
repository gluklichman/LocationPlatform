package com.bogtrain.locationclient.remote;

import com.bogtrain.locationclient.model.MapPoint;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public interface IRemoteDataProvider {
    MapPoint[] getCurrentPoints();
}
