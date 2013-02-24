package com.jt.tagger;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;

public class ShareActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        
        final Button shareBtn = (Button) findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	//TODO share

            	
            }
        });
        
        final Button stornoBtn = (Button) findViewById(R.id.stornoBtn);
        stornoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	Intent intent = new Intent(ShareActivity.this, main.class);
            	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //clears activity stack, after hitting storno button it is not possible go back to this share activity
                startActivity(intent);

            }
        });
        
        // retrieve data
        String data = getIntent().getStringExtra("RESULTS");
        final TextView txt = (TextView) findViewById(R.id.resultTxtView);
        txt.setText(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_share, menu);
        return true;
    }

    
}
