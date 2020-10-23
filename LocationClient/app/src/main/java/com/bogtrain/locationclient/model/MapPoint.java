package com.bogtrain.locationclient.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class MapPoint {
    private LatLng position = null;
    private String title = null;
    private String description = null;

    public MapPoint(LatLng pos, String title, String description) {
        this.position = pos;
        this.title = title;
        this.description = description;
    }

    public LatLng getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
