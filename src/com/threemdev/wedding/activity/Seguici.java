package com.threemdev.wedding.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.threemdev.fmw.R;

public class Seguici extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seguici);
		ImageView imgFaceFabi = (ImageView)findViewById(R.id.imgFaceFabi);
		ImageView imgFaceManu = (ImageView)findViewById(R.id.imgFaceManu);
		
		imgFaceFabi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/fabiola.amaru")));
			}
		});
		imgFaceManu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Emanueleluciano.torregrossa")));
			}
		});
		Animation a = new AlphaAnimation(0.00f, 1.00f);

		a.setDuration(1500);
		a.setAnimationListener(new AnimationListener() {

		    public void onAnimationStart(Animation animation) {
		        // TODO Auto-generated method stub

		    }

		    public void onAnimationRepeat(Animation animation) {
		        // TODO Auto-generated method stub

		    }

		    public void onAnimationEnd(Animation animation) {
		    }
		});
		imgFaceFabi.startAnimation(a);
		imgFaceManu.startAnimation(a);
	}
}
