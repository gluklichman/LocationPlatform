package com.bogtrain.locationclient.model;

import android.util.Log;

import com.bogtrain.locationclient.remote.IRemoteDataProvider;
import com.bogtrain.locationclient.remote.MockDataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class PointsStorage {

    private static final long UPDATE_POINTS_INITIAL_DELAY = 0;
    private static final long UPDATE_POINTS_DELAY = 60;

    private static PointsStorage INSTANCE = null;

    private List<MapPoint> pointsCash = null;
    private IRemoteDataProvider dataProvider = null;

    private ScheduledExecutorService updatePointsScheduler = null;

    public static PointsStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PointsStorage();
        }
        return INSTANCE;
    }

    public PointsStorage() {
        pointsCash = new ArrayList<MapPoint>();
        dataProvider = new MockDataProvider();

        updatePointsScheduler = Executors.newScheduledThreadPool(1);

        updatePointsScheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                pointsCash = dataProvider.getCurrentPoints();
                Log.v("PointsStorage", "Perform points storage update");
            }
        }, UPDATE_POINTS_INITIAL_DELAY, UPDATE_POINTS_DELAY, TimeUnit.SECONDS);
    }

    public List<MapPoint> getAvailabalePoints() {
        return pointsCash;
    }

}
