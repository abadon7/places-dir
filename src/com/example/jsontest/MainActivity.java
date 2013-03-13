package com.example.jsontest;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;



public class MainActivity extends SherlockListActivity {
	
	
	
	private static String url = "http://www.e-innovar.com/android/places.php";
	
	private static final String TAG_MARKERS = "Markers"; 
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_LATITUDE = "latitude";
	private static final String TAG_LONGITUDE = "longitude";
	
	JSONArray lugares = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		ArrayList<HashMap<String, String>> lugaresList = new ArrayList<HashMap<String, String>>();
		
		
		JSONParser jParser = new JSONParser();
		
		JSONObject json = jParser.getJSONFromUrl(url);
		
		try {
			lugares = json.getJSONArray(TAG_MARKERS);
			
			for(int i=0; i < lugares.length(); i++){
				JSONObject c = lugares.getJSONObject(i);
				
				String id = c.getString(TAG_ID);
				String name = c.getString(TAG_NAME);
				String latitude = c.getString(TAG_LATITUDE);
				String longitude = c.getString(TAG_LONGITUDE);
				
				HashMap<String, String> map = new HashMap<String, String>();
				
				map.put(TAG_ID, id);
				map.put(TAG_LONGITUDE, longitude);
				map.put(TAG_NAME, name);
				map.put(TAG_LATITUDE, latitude);
				
				lugaresList.add(map);
				
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		ListAdapter adapter = new SimpleAdapter(this, lugaresList,
				R.layout.list_item,
				new String[] {TAG_NAME, TAG_LATITUDE, TAG_LONGITUDE}, new int[] {
					R.id.name, R.id.latitude, R.id.longitude});
		
		setListAdapter(adapter);
		
		
		ListView lv = getListView();
		
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,

					int position, long id) {
				
				String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
				String lati = ((TextView) view.findViewById(R.id.latitude)).getText().toString();
				String lngi = ((TextView) view.findViewById(R.id.longitude)).getText().toString();
				
				
				
				Intent in = new Intent(getApplicationContext(), MapsActivity.class);
				in.putExtra(TAG_NAME, name);
				in.putExtra(TAG_LATITUDE, lati);
				in.putExtra(TAG_LONGITUDE, lngi);
				startActivity(in);
				
				
			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		  MenuInflater inflater = getSupportMenuInflater();
	        inflater.inflate(R.menu.main, menu);
	        return true;
	}

}
