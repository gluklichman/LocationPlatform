package com.bogtrain.locationclient.map;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class MapPresenter implements MapContract.Presenter {

    MapContract.View mapView = null;

    MapPresenter(MapContract.View view) {
        mapView = view;
    }

}
