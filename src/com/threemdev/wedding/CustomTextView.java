package com.threemdev.wedding;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends TextView {
	
	 Typeface tf;
	
	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		tf = Typeface.createFromAsset(getContext().getAssets(), "MTCORSVA.TTF");
		this.setTypeface(tf);
		
	}
	
	public CustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		tf = Typeface.createFromAsset(getContext().getAssets(), "MTCORSVA.TTF");
		this.setTypeface(tf);
		
	}
	
	public CustomTextView(Context context) {
		super(context);

		tf = Typeface.createFromAsset(getContext().getAssets(), "MTCORSVA.TTF");
		this.setTypeface(tf);
		
	}

	

}
