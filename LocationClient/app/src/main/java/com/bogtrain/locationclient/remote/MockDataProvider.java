package com.bogtrain.locationclient.remote;

import com.bogtrain.locationclient.model.MapPoint;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class MockDataProvider implements IRemoteDataProvider {

    private MapPoint[] mockPoints = null;

    public MockDataProvider() {

        mockPoints = new MapPoint[] {
            new MapPoint(new LatLng(53.864210, 27.480421), "Home", "Home description"),
            new MapPoint(new LatLng(53.905476, 27.520593), "Work", "Work description")
        };

    }

    @Override
    public MapPoint[] getCurrentPoints() {
        return mockPoints;
    }
}
