package com.threemdev.wedding.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.threemdev.fmw.R;

public class ChiActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chi);
		ImageView imgFaby = (ImageView)findViewById(R.id.imgFabi2);
		ImageView imgManu = (ImageView)findViewById(R.id.imgManu2);
		com.threemdev.wedding.CustomTextView tvFabi = (com.threemdev.wedding.CustomTextView)findViewById(R.id.textView1);
		tvFabi.setOnClickListener(this);
		com.threemdev.wedding.CustomTextView tvManu = (com.threemdev.wedding.CustomTextView)findViewById(R.id.textView2);
		tvManu.setOnClickListener(this);
		
		imgFaby.setOnClickListener(this);
		imgManu.setOnClickListener(this);
		
		AnimationSet animSet = new AnimationSet(true);
		
		RotateAnimation anim = new RotateAnimation(0, 360,
	            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
	    anim.setInterpolator(new LinearInterpolator());
	    anim.setDuration(300);
	    anim.setFillEnabled(true);
	    anim.setFillAfter(true);
	    anim.setRepeatCount(3);
	    Animation a = new AlphaAnimation(0.00f, 1.00f);
		a.setDuration(2000);
	    animSet.addAnimation(anim);
	    animSet.addAnimation(a);
	    
	    
		imgFaby.startAnimation(animSet);
		imgManu.startAnimation(animSet);

		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.imgFabi2:
		case R.id.textView1:
			Dialog dialog = new Dialog(ChiActivity.this);
			dialog.setContentView(R.layout.dialog_detail);
			dialog.setTitle("Fabiola Amarù");
			ImageView imgFaby = (ImageView)dialog.findViewById(R.id.imgDetail);
			imgFaby.setImageResource(R.drawable.fabiola);
			com.threemdev.wedding.CustomTextView tv = (com.threemdev.wedding.CustomTextView)dialog.findViewById(R.id.tvDetail);
			tv.setText("Nata a Gela il 17/09/1986 amante del caffè sin dalla pancia della mamma.\nAttenta ai dettagli e puntigliosa, cerca sempre il pelo nell'uovo e spesso lo trova!");
			dialog.show();
			break;
		case R.id.imgManu2:
		case R.id.textView2:
			Dialog dialog2 = new Dialog(ChiActivity.this);
			dialog2.setContentView(R.layout.dialog_detail);
			dialog2.setTitle("Emanuele Luciano Torregrossa");
			ImageView imgManu = (ImageView)dialog2.findViewById(R.id.imgDetail);
			imgManu.setImageResource(R.drawable.eman);
			com.threemdev.wedding.CustomTextView tv2 = (com.threemdev.wedding.CustomTextView)dialog2.findViewById(R.id.tvDetail);
			tv2.setText("Nato a Gela il 13/09/1984.\nCresciuto a Civitavecchia e ritornato in Sicilia con il ballo nelle vene.\nAma stare al centro dell'attenzione e spesso ci riesce.");
			dialog2.show();
			break;
		default:
			break;
		}
		
	}
	
}
