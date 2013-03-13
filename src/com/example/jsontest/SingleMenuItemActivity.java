package com.example.jsontest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity  extends Activity {
	
	// JSON node keys
	private static final String TAG_NAME = "name";
	private static final String TAG_LATITUDE = "latitude";
	private static final String TAG_LONGITUDE = "longitude";
	
	String name2;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String name = in.getStringExtra(TAG_NAME);
        String lati = in.getStringExtra(TAG_LATITUDE);
        String lngi = in.getStringExtra(TAG_LONGITUDE);
        
        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblLati = (TextView) findViewById(R.id.latitude_label);
        TextView lblLngi = (TextView) findViewById(R.id.longitude_label);
        
        name2 = name;
        
        lblName.setText(name2);
        lblLati.setText(lati);
        lblLngi.setText(lngi);
    }
}
