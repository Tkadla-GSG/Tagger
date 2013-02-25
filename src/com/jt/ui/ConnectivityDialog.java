package com.jt.ui;

import com.jt.tagger.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;

public class ConnectivityDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.connectivity_title);
        builder.setMessage(R.string.connectivity_message)
               .setPositiveButton( R.string.menu_settings, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   
                	   enableWirelessSettings();	   
                   }
               })
               .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog, force app to close
                	   getActivity().moveTaskToBack(true);
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
	
	private void enableWirelessSettings() {
	    Intent settingsIntent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
	    startActivity(settingsIntent);
	}
}
