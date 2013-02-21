package com.joyatwork.mylocationonmap;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ShowMapActivity extends Activity {
	static final LatLng BLAVA_CASTLE = new LatLng(48.14174, 17.099971);
	static final LatLng SENICA_SWEAT_HOME = new LatLng(48.678967, 17.365417);
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_map);
		
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		/*
		MapView mapView = (MapView) findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);

		try {
		     MapsInitializer.initialize(this);
		 } catch (GooglePlayServicesNotAvailableException e) {
		     e.printStackTrace();
		 }

		map = mapView.getMap();
		*/
		
		/* */
		if (map != null) {
			map.addMarker(new MarkerOptions()
				.position(SENICA_SWEAT_HOME)
				.title("Senica, Robotnicka ul.")
				.snippet("Sweat Home")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_maps_indicator_current_position))
				);
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(SENICA_SWEAT_HOME, 15));
			map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		}
		else {
			// display warning or something
		}
		/* */
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_show_map, menu);
		return true;
	}

}
