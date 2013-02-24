package com.jt.tagger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class main extends Activity {

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
    	         String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
    	         
    	         Intent newIntent = new Intent(this, ShareActivity.class);
    	         newIntent.putExtra("RESULTS", contents);
                 startActivity(newIntent);
    	         
    	      } else if (resultCode == RESULT_CANCELED) {
    	         // Handle cancel
    	      }
    	   }
    	}

    
}
