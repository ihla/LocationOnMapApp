package com.joyatwork.mylocationonmap;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;

/**
 * This shows how to create a simple activity with a raw MapView and add a customized marker to it.
 * This requires forwarding all the important lifecycle methods onto MapView.
 */
public class ShowMapActivity extends Activity {
	
	private MapView mapView;
	private GoogleMap map;
	
	static final LatLng SENICA_SWEAT_HOME = new LatLng(48.678967, 17.365417);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_map);
		
		mapView = (MapView) findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);
		
		/*
		 * this init is necessary here!
		 * It must be called because some classes such as BitmapDescriptorFactory and CameraUpdateFactory need to be initialized.
		 */ 
		try {
		     MapsInitializer.initialize(this);
		 } catch (GooglePlayServicesNotAvailableException e) {
		     e.printStackTrace();
		 }

		setUpMapIfNeeded();		
	}

    private void setUpMapIfNeeded() {
        if (map == null) {
            map = ((MapView) findViewById(R.id.map)).getMap();
            if (map != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
		map.addMarker(new MarkerOptions()
		.position(SENICA_SWEAT_HOME)
		.title("Senica, Robotnicka ul.")
		.snippet("Sweat Home")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_maps_indicator_current_position))
		);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(SENICA_SWEAT_HOME, 15));
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }

	@Override
	protected void onResume() {
		super.onResume();
		mapView.onResume();
		
		setUpMapIfNeeded();
	}

	@Override
	protected void onPause() {
		mapView.onPause();
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		mapView.onDestroy();
		super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mapView.onLowMemory();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

}
