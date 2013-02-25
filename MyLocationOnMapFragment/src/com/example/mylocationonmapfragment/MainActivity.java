package com.example.mylocationonmapfragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 * <p>
 * Notice how we deal with the possibility that the Google Play services APK is not
 * installed/enabled/updated on a user's device.
 */
public class MainActivity extends android.support.v4.app.FragmentActivity {
    /**
     * Note that this may be null if the Google Play services APK is not available.
     */
    private GoogleMap map;
    
    private static final LatLng HOME = new LatLng(48.678967, 17.365417);
    /**
     * demo of geonames services
     */
    //http://api.geonames.org/findNearestIntersectionOSM?lat=48.678967&lng=17.365417&username=demo
    private static final LatLng NEAREST_INTERSECTION = new LatLng(48.679365, 17.363247);
    
    //http://api.geonames.org/findNearbyStreetsOSM?lat=48.678967&lng=17.365417&username=demo
    private static final LatLng STUROVA_END = new LatLng(48.676318, 17.365105);
    private static final LatLng BOTTOVA_START = new LatLng(48.677368, 17.366263);
    
    private static final CameraPosition SENICA_SWEAT_HOME =
            new CameraPosition.Builder()
    				.target(HOME)
                    .zoom(16.5f)
                    .bearing(0)
                    .tilt(65)
                    .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #map} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView
     * MapView}) will show a prompt for the user to install/update the Google Play services APK on
     * their device.
     * <p>
     * A user can return to this Activity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the Activity may not have been
     * completely destroyed during this process (it is likely that it would only be stopped or
     * paused), {@link #onCreate(Bundle)} may not be called again so we should call this method in
     * {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (map == null) {
            // Try to obtain the map from the SupportMapFragment.
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (map != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     * <p>
     * This should only be called once and when we are sure that {@link #map} is not null.
     */
    private void setUpMap() {
    	map.getUiSettings().setZoomControlsEnabled(false); //zooming by gestures not buttons

    	map.addMarker(new MarkerOptions().position(HOME).title("Sweat Home")
        		.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_maps_indicator_current_position)));
        map.addMarker(new MarkerOptions().position(NEAREST_INTERSECTION).title("Sturova krizovatka"));
        map.addMarker(new MarkerOptions().position(STUROVA_END).title("Sturova koniec"));
        map.addMarker(new MarkerOptions().position(BOTTOVA_START).title("Bottova zaciatok"));
        
        map.animateCamera(CameraUpdateFactory.newCameraPosition(SENICA_SWEAT_HOME), 2000, null);


    }
}
