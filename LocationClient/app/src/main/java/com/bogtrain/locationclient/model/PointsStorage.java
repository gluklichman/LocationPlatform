package com.bogtrain.locationclient.model;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class PointsStorage {

    private static PointsStorage INSTANCE = null;

    public PointsStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PointsStorage();
        }
        return INSTANCE;
    }

}
