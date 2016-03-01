package events;

import com.eventassociate.weddingapp.R;
import events.AppController;
import events.Movie;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Movie> movieItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<Movie> movieItems) {
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
			convertView = inflater.inflate(R.layout.weddevents_list_row, null);

		TextView title = (TextView) convertView.findViewById(R.id.title);

		TextView day = (TextView) convertView.findViewById(R.id.releaseDay);

		TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

		TextView month = (TextView) convertView.findViewById(R.id.releaseMonth);

		TextView address = (TextView) convertView.findViewById(R.id.thumbnail);
		
		
		TextView time = (TextView) convertView.findViewById(R.id.releaseYear2);  

		// getting movie data for the row
		Movie m = movieItems.get(position);

		// title
		title.setText(m.getTitle());

		day.setText(String.valueOf(m.getDay()) + "-");

		month.setText(String.valueOf(m.getMonth()) + "-");

		address.setText(m.getThumbnailUrl());

		// release year
		year.setText(String.valueOf(m.getYear()));

		return convertView;
	}

}