package com.threemdev.wedding.adapter;

import java.util.ArrayList;
import java.util.List;

import com.threemdev.fmw.R;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	private Context context;
	private List<String> listElement;

	public CustomAdapter(Context context, ArrayList<String> listElement) {
		this.context = context;
		this.listElement = listElement;
	}

	public class ViewAdded {
		TextView text;
		ImageView image;
		LinearLayout ll;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listElement.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewAdded viewAdded = null;
		LayoutInflater layout = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (view == null) {
			view = layout.inflate(R.layout.element, null);
			viewAdded = new ViewAdded();
			viewAdded.text = (TextView) view.findViewById(R.id.listTv);
			viewAdded.image = (ImageView) view.findViewById(R.id.listImage);
			viewAdded.ll = (LinearLayout)view.findViewById(R.id.linearLayout1);
			view.setTag(viewAdded);
			viewAdded.text.setText(listElement.get(position));
			viewAdded.text.setTextColor(Color.BLACK);
			switch (position) {
			case 0:
				viewAdded.image.setBackgroundResource(R.drawable.fedi);
				break;
			case 1:
				viewAdded.image.setBackgroundResource(R.drawable.maps_mndroid);
				break;
			case 2:
				viewAdded.image.setBackgroundResource(R.drawable.point_and_shoot_camera_256);
				break;
			case 3:
				viewAdded.image.setBackgroundResource(R.drawable.tempo_icon);
				break;

			default:
				break;
			}
			
		} else {
			viewAdded = (ViewAdded) view.getTag();
		}
		return view;
	}

}
