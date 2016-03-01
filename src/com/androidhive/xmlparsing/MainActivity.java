package com.androidhive.xmlparsing;

import com.androidhive.xmlparsing.CustomListAdapter;
import com.androidhive.xmlparsing.AppController;
import com.androidhive.xmlparsing.Moviealbum;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.androidhive.xmlparsing.Moviealbum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.eventassociate.weddingapp.R;

public class MainActivity extends Activity implements OnClickListener{
	// Log tag
	private static final String TAG = MainActivity.class.getSimpleName();

	// Movies json url
	private static final String url = "http://eventassociate.com/wedding/androidxml.php";
	private ProgressDialog pDialog;
	private List<Moviealbum> movieList = new ArrayList<Moviealbum>();
	private ListView listView;
	private CustomListAdapter adapter;
	
	TextView Shimmer2;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        
        ActionBar bar = getActionBar();
        getActionBar().setDisplayHomeAsUpEnabled(true);
		// changing action bar color
				getActionBar().setBackgroundDrawable(
						new ColorDrawable(Color.parseColor("#A22B13")));
       
        
        
		
        setContentView(R.layout.reach_main);
		
        getActionBar().setDisplayHomeAsUpEnabled(true);
		listView = (ListView) findViewById(R.id.list);
		
		Shimmer2 = (TextView) findViewById(R.id.shimmer2);
		
		Typeface type43210 = Typeface.createFromAsset(getAssets(),"fonts/AlexBrush-Regular.ttf"); 
	     Shimmer2.setTypeface(type43210);
		
		adapter = new CustomListAdapter(this, movieList);
		listView.setAdapter(adapter);
		
		Animation shake2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_in);
		Shimmer2.startAnimation(shake2);
		
		Shimmer2.postDelayed(new Runnable() {
			public void run() {
				Animation shake3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_down_out);
				Shimmer2.startAnimation(shake3);
			    Shimmer2.setVisibility(View.INVISIBLE);
			}
			}, 3000);
		
		
		
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Moviealbum m5 = movieList.get(position);

				Intent i = new Intent(getApplicationContext(),
						com.androidhive.xmlparsing.SingleMenuItemActivity.class);

				i.putExtra("movieobject", m5);
				startActivity(i);
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		pDialog = new ProgressDialog(this);
		// Showing progress dialog before making http request
		pDialog.setMessage("Loading...");
		pDialog.show();

		

		// Creating volley request obj
		JsonArrayRequest movieReq = new JsonArrayRequest(url,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.d(TAG, response.toString());
						hidePDialog();

						// Parsing json
						for (int i = 0; i < response.length(); i++) {
							try {

								JSONObject obj = response.getJSONObject(i);
								Moviealbum movie = new Moviealbum();
								
								
									
								movie.setTitle(obj.getString("placeName"));								
								movie.setYear(obj.getString("latitude"));
								movie.setDay(obj.getString("longitude"));
							
								

								

								// adding movie to movies array
								movieList.add(movie);

							} catch (JSONException e) {
								e.printStackTrace();
							}

						}

						// notifying list adapter about data changes
						// so that it renders the list view with updated data
						adapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						VolleyLog.d(TAG, "Error: " + error.getMessage());
						hidePDialog();

					}
				});

		// Adding request to request queue
		AppController.getInstance().addToRequestQueue(movieReq);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		hidePDialog();
	}

	private void hidePDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	

	

	
}
