package com.jt.ui;

import com.jt.tagger.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;

public class GpsDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.GPS_title);
        builder.setMessage(R.string.GPS_message)
               .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   
                	   enableLocationSettings();	   
                   }
               })
               .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    
	private void enableLocationSettings() {
	    Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	    startActivity(settingsIntent);
	}
}
