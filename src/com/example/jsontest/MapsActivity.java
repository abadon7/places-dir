package com.example.jsontest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends android.support.v4.app.FragmentActivity {

	private static final LatLng ITAGUI = new LatLng(6.17759,-75.612987);
	
	private static final String TAG_NAME = "name";
	private static final String TAG_LATITUDE = "latitude";
	private static final String TAG_LONGITUDE = "longitude";
	
	private static final String  LABEL2 = "henry velez";
	
	String name2 = "Carolina";
	
	
	private GoogleMap nMapa;
//	private int vista = 0;

	private String name;
	
	String lati;
	String lngi;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		setUpMapIfNeeded();
		
		Intent in = getIntent();
        
        name = in.getStringExtra(TAG_NAME);
        
      
        
        name2 = "Henry Velez";
        
       
				
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}
	
	private void setUpMapIfNeeded(){
		if (nMapa == null) {
			nMapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
			
			if (nMapa != null) {
				setUpMap();
			}
		}
	}
	
	private void setUpMap(){
		
		Intent in = getIntent();
        
        name = in.getStringExtra(TAG_NAME);
        lati = in.getStringExtra(TAG_LATITUDE);
        lngi = in.getStringExtra(TAG_LONGITUDE);
        
        double lati1 = Double.parseDouble(lati);
        double lngi1 = Double.parseDouble(lngi);
        
        LatLng CENTRO = new LatLng(lati1, lngi1);
        
        
		
		nMapa.addMarker(new MarkerOptions()
				.position(new LatLng(lati1, lngi1))
				.title(name)
				.snippet("pensamos en el futuro"));
		nMapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		nMapa.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTRO, 15));
		nMapa.animateCamera(CameraUpdateFactory.zoomIn());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
	}
	
	
	
	

}
