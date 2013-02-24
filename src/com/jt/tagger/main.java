package com.jt.tagger;

import com.jt.ui.GpsDialog;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class main extends FragmentActivity {
	
	@Override
	protected void onStart() {
	    super.onStart();

	    LocationManager locationManager =
	            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

	    if (!gpsEnabled) {
	        
	    	new GpsDialog().show(getSupportFragmentManager(), "GPS disabled");
	        
	    }
	}



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button button = (Button) findViewById(R.id.scanBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            	//intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            	startActivityForResult(intent, 0);

            	
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	   if (requestCode == 0) {
    	      if (resultCode == RESULT_OK) {
    	         String contents = intent.getStringExtra("SCAN_RESULT");
    	         //String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
    	         
    	         Intent newIntent = new Intent(this, ShareActivity.class);
    	         newIntent.putExtra("RESULTS", contents);
                 startActivity(newIntent);
    	         
    	      } else if (resultCode == RESULT_CANCELED) {
    	         // Handle cancel
    	      }
    	   }
    	}

    
}
