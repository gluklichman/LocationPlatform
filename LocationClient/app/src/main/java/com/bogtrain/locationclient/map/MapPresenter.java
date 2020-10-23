package com.bogtrain.locationclient.map;

import android.os.Handler;
import android.util.Log;

import com.bogtrain.locationclient.model.MapPoint;
import com.bogtrain.locationclient.model.PointsStorage;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class MapPresenter implements MapContract.Presenter {

    private static final long UPDATE_PERIOD_SECONDS = 10;
    private static final long UPDATE_INITIAL_DELAY = 0;

    private MapContract.View mapView = null;
    private ScheduledExecutorService updateViewScheduler = null;
    private Handler threadHandler = null;

    MapPresenter(MapContract.View view) {
        mapView = view;
        threadHandler = new Handler();

        updateViewScheduler = Executors.newScheduledThreadPool(1);

        updateViewScheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                //Log.v("APP", "Update view");

                threadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<MapPoint> points = PointsStorage.getInstance().getAvailabalePoints();
                        MapPoint[] pointsArray = points.toArray(new MapPoint[points.size()]);
                        mapView.UpdateMapPoints(pointsArray);
                    }
                });
            }
        }, UPDATE_INITIAL_DELAY, UPDATE_PERIOD_SECONDS, TimeUnit.SECONDS);

    }
}
