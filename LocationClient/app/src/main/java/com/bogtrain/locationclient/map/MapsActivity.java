package com.bogtrain.locationclient.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.bogtrain.locationclient.model.MapPoint;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapContract.View {

    private GoogleMap mMap;

    private MapPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        presenter = new MapPresenter(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng home = new LatLng(53.864210, 27.480421);
        LatLng work = new LatLng(53.905476, 27.520593);

        mMap.addMarker(new MarkerOptions().position(home).title("Home marker").snippet("test snippet"));
        mMap.addMarker(new MarkerOptions().position(work).title("Work marker").snippet("another snippet"));

        UiSettings mapUISettings = mMap.getUiSettings();
        mapUISettings.setCompassEnabled(true);
        mapUISettings.setMapToolbarEnabled(false);
        mapUISettings.setMyLocationButtonEnabled(true);
        mapUISettings.setZoomControlsEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
    }

    @Override
    public void UpdateMapPoints(MapPoint[] points) {
        //TODO; implement
    }
}
