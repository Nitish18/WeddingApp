package com.androidhive.xmlparsing;

import com.eventassociate.weddingapp.R;
import com.androidhive.xmlparsing.AppController;
import com.androidhive.xmlparsing.Moviealbum;
import com.androidhive.xmlparsing.MainActivity;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;


public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Moviealbum> movieItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();
	static final String KEY_NAME = "placeName";
	static final String KEY_COST = "latitude";
	static final String KEY_DESC = "longitude";

	public CustomListAdapter(Activity activity, List<Moviealbum> movieItems) {
		this.activity = activity;
		this.movieItems = movieItems;
	}

	@Override
	public int getCount() {
		return movieItems.size();
	}

	@Override
	public Object getItem(int location) {
		return movieItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.reach_list_item, null);

		

		TextView Placename = (TextView) convertView.findViewById(R.id.title);
		
		
		TextView Placelat = (TextView) convertView.findViewById(R.id.releaseYear);
		
		
		TextView Placelong = (TextView) convertView.findViewById(R.id.releaseDay);
		
		
		Moviealbum m = movieItems.get(position);
		
		
		
		Placename.setText(m.getTitle());
		
		
		Placelat.setText(String.valueOf(m.getYear()));
		
		
		Placelong.setText(String.valueOf(m.getDay()));
		
		
		return convertView;
	}

	
	
	
	
	

}