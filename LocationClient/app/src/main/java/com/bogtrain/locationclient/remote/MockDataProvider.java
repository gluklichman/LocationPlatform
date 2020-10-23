package com.bogtrain.locationclient.remote;

import com.bogtrain.locationclient.model.MapPoint;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class MockDataProvider implements IRemoteDataProvider {

    private List<MapPoint> mockPoints = null;

    public MockDataProvider() {

        mockPoints = new ArrayList<MapPoint>();
        mockPoints.add(new MapPoint(new LatLng(53.864210, 27.480421), "Home", "Home description"));
        mockPoints.add(new MapPoint(new LatLng(53.905476, 27.520593), "Work", "Work description"));
        mockPoints.add(new MapPoint(new LatLng(53.947178, 27.595143), "Elves", "Elvezzz"));
    }

    @Override
    public List<MapPoint> getCurrentPoints() {
        return mockPoints;
    }
}
