package com.threemdev.wedding.activity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.google.android.gms.maps.MapView;
import com.threemdev.fmw.R;

public class Mappa extends Activity implements OnClickListener{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.mappa);
	ImageView imgChiesa = (ImageView)findViewById(R.id.imgChiesa);
	ImageView imgPranzo = (ImageView)findViewById(R.id.imgPranzo);
	com.threemdev.wedding.CustomTextView tvChiesa = (com.threemdev.wedding.CustomTextView)findViewById(R.id.tvChiesa);
	tvChiesa.setOnClickListener(this);
	com.threemdev.wedding.CustomTextView tvPranzo = (com.threemdev.wedding.CustomTextView)findViewById(R.id.tvPranzo);
	tvPranzo.setOnClickListener(this);
	imgPranzo.setOnClickListener(this);
	imgChiesa.setOnClickListener(this);
	
	
	imgPranzo.startAnimation(AnimationUtils.loadAnimation(Mappa.this, R.anim.overshoot));
	imgChiesa.startAnimation(AnimationUtils.loadAnimation(Mappa.this, R.anim.overshoot));

}

@Override
public void onClick(View v) {
	int id = v.getId();
	switch (id) {
	case R.id.tvChiesa:
	case R.id.imgChiesa:
		Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("google.navigation:q=37.0691429, 14.242035"));
		startActivity(i);
		break;
	case R.id.tvPranzo:
	case R.id.imgPranzo:
		Intent i2 = new Intent(Intent.ACTION_VIEW,Uri.parse("google.navigation:q=37.3385872, 13.4205821"));
		startActivity(i2);
	default:
		break;
	}
	
}
	 	       
}
