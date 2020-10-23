package com.bogtrain.locationclient.map;

import android.os.Handler;

import com.bogtrain.locationclient.model.MapPoint;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public interface MapContract {

    public interface View {
        void UpdateMapPoints(MapPoint[] points);
    }

    public interface Presenter {

    }
}
