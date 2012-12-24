package com.example.locationinfo;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txtLat;
	TextView txtLong;
	TextView txtElev;
	TextView txtBear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtLat = (TextView) findViewById(R.id.txtLat);
		txtLong = (TextView) findViewById(R.id.txtLong);
		txtElev = (TextView) findViewById(R.id.txtElev);
		txtBear = (TextView) findViewById(R.id.txtBear);
		
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener ll = new myLocationListener();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
		
	}

	class myLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location arg0) {
			if (arg0 != null) {
				double pLat = arg0.getLatitude();
				double pLong = arg0.getLongitude();
				double pElev = arg0.getAltitude();
				double pBear = arg0.getBearing();
				
				txtLat.setText(Double.toString(pLat));
				txtLong.setText(Double.toString(pLong));
				txtElev.setText(Double.toString(pElev));
				txtBear.setText(Double.toString(pBear));
				
			}
			
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/


