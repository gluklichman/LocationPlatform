package com.bogtrain.locationclient.map;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.bogtrain.locationclient.model.MapPoint;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapContract.View, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap = null;

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

    @Override
    protected void onDestroy()
    {
        mMap.setOnMarkerClickListener(null);
        super.onDestroy();
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

        mMap.setOnMarkerClickListener(this);

        UiSettings mapUISettings = mMap.getUiSettings();
        mapUISettings.setCompassEnabled(true);
        mapUISettings.setMapToolbarEnabled(false);
        mapUISettings.setMyLocationButtonEnabled(true);
        mapUISettings.setZoomControlsEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(53.864210, 27.480421)));
    }

    @Override
    public void UpdateMapPoints(MapPoint[] points) {
        if (IsMapReady()) {
            mMap.clear();
            for (MapPoint point : points) {
                LatLng pointMarker = point.getPosition();
                Marker newMarker = mMap.addMarker(new MarkerOptions().position(pointMarker));
                newMarker.setTag(point);
            }
        }
    }

    public boolean IsMapReady() {
        return mMap != null;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.getTag() == null)
        {
            return false;
        }

        MapPoint point = (MapPoint)marker.getTag();
        if (point == null)
        {
            return false;
        }
        Log.v("MarkerClick", point.getTitle() + " " + point.getDescription());
        return false;
    }
}
