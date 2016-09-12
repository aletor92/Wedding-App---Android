package com.threemdev.wedding.activity;

import java.util.Arrays;

import com.threemdev.fmw.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
  
  TextView tv;
  ImageView img;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    tv = (TextView) findViewById(R.id.matchit);
    img = (ImageView)findViewById(R.id.imageViewPic);
    tv.setVisibility(TextView.GONE);
    float height = getApplicationContext().getResources().getDisplayMetrics().heightPixels;
	float heightLogo=img.getHeight();
	float center=((height/2)-(heightLogo/2));
    TranslateAnimation anim = new TranslateAnimation(0, 0, 0, -center);
	anim.setDuration(1000);
    anim.setFillAfter(true);
    img.setAnimation(anim);
    anim.setAnimationListener(new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			tv.setVisibility(TextView.VISIBLE);
			startHome();
		}
	});
  }
    
  private void startHome(){
	  new Handler().postDelayed(new Runnable() {
		
		@Override
		public void run() {
			startActivity(new Intent(MainActivity.this,Home.class));
			finish();
		}
	}, 1000);
  }
}
