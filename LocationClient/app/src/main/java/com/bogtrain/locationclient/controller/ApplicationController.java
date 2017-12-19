package com.bogtrain.locationclient.controller;

import com.bogtrain.locationclient.remote.IRemoteDataProvider;
import com.bogtrain.locationclient.remote.MockDataProvider;

/**
 * Created by Gluklichman on 19-Dec-17.
 */

public class ApplicationController {
    //Singleton implementation
    private ApplicationController instance = null;

    public ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }

    //singleton implementation end

    IRemoteDataProvider dataServer = null;

    public ApplicationController() {
        init();
    }

    private void init() {
        dataServer = new MockDataProvider();    //TODO: when server is ready, this should be changed to component for server interaction
    }

}
