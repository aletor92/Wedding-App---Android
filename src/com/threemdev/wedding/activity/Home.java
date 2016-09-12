package com.threemdev.wedding.activity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;
import com.threemdev.fmw.R;

public class Home extends Activity implements OnClickListener {
	
	final String VERSION = "4";
	int counter = 7;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home);
	checkVersion();
	Button chi = (Button)findViewById(R.id.chi);
	chi.setOnClickListener(this);
	Button dove = (Button)findViewById(R.id.dove);
	dove.setOnClickListener(this);
	Button seguici = (Button)findViewById(R.id.seguici);
	seguici.setOnClickListener(this);
	Button countdown = (Button)findViewById(R.id.countdown);
	countdown.setOnClickListener(this);
	ImageView imgHeader = (ImageView)findViewById(R.id.imgHeader);
	startPush();
	imgHeader.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			counter--;
			if(counter<6 && counter != 0){
				Toast.makeText(Home.this, "Premi altre " + counter + " volte. :)", Toast.LENGTH_SHORT).show();
			}
			if(counter == 0){
				Dialog dialog = new Dialog(Home.this);
				dialog.setContentView(R.layout.dialog_about);
				dialog.setTitle("About");
				dialog.show();
				counter = 7;
			}
		}
	});
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	int id = v.getId();
	switch(id){
	case R.id.chi:
		startActivity(new Intent(Home.this,ChiActivity.class));
		break;
	case R.id.dove:
		startActivity(new Intent(Home.this,Mappa.class));
		break;

	case R.id.seguici:
		startActivity(new Intent(Home.this,Seguici.class));
		break;

	case R.id.countdown:
		Intent i = new Intent(Home.this,RemaningTime.class);
		startActivity(i);
		break;
	default:
		break;
	}
}

private void startPush(){
	
	//push
			Parse.initialize(this, "GSPWKrRxO6vNys3Oxg5oBtTzD3FrH1KKz7BNHrE3", "004MpgWJBriw8OPMhbHl9bvyh02AvIAb3c4oVcH7");
			ParseUser.enableAutomaticUser();
			ParseACL defaultACL = new ParseACL();
			// Optionally enable public read access.
			// defaultACL.setPublicReadAccess(true);
			ParseACL.setDefaultACL(defaultACL, true);
			PushService.setDefaultPushCallback(this, Home.class);
			ParseInstallation installation = ParseInstallation.getCurrentInstallation();
			installation.saveInBackground();
			ParseAnalytics.trackAppOpened(getIntent());
			
			//push
}

public void checkVersion(){
	
	if(isOnline()){
		Version version = new Version();
		version.execute(null);
	}
	
}

public boolean isOnline() {
    ConnectivityManager cm =
        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
        return true;
    }
    return false;
}

public class Version extends AsyncTask<String, Void, Void>{
	String response = "";
//	ProgressDialog pd = new ProgressDialog(Home.this);
	@Override
	protected Void doInBackground(String... params) {
		try {
			URL url = new URL("http://www.ricomsrl.it/update.php");
			URLConnection connection = url.openConnection();
			Scanner scan = new Scanner(connection.getInputStream());
			while(scan.hasNext()){
				response += scan.nextLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
//		pd.setTitle("Verifico Aggiornamenti");
//		pd.setCancelable(false);
//		pd.setMessage("Attendere...");
//		pd.show();
		
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
//		if(pd.isShowing()){
//			pd.dismiss();
//		}
		if(!response.trim().equals(VERSION)){
			AlertDialog.Builder dialog = new AlertDialog.Builder(Home.this);
			dialog.setTitle("Aggiornamento");
			dialog.setMessage("C'è una nuova versione dell'app.\nVuoi scaricare?");
			dialog.setCancelable(false);
			dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.ricomsrl.it/Wedding%20App%20Manu%20e%20Faby.apk"));
					startActivity(i);
				}
			});
			dialog.setNegativeButton("Annulla",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(Home.this, "App non aggiornata", Toast.LENGTH_SHORT).show();
				}
			});
			dialog.show();
		}
	}
	
	
}

	
}
