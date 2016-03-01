package album;

import album.CustomListAdapter;
import album.AppController;
import album.Moviealbum;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.eventassociate.weddingapp.R;

public class MainActivity extends Activity implements OnClickListener {
	// Log tag
	private static final String TAG = album.MainActivity.class.getSimpleName();

	// Movies json url
	private static final String url = "http://eventassociate.com/wedding/androidadminimages";
	private ProgressDialog pDialog;
	private List<Moviealbum> movieList = new ArrayList<Moviealbum>();

	private GridView gridView;
	private CustomListAdapter adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        ActionBar actionBar1 = getActionBar();
        
        actionBar1.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#660000")));
        
        
        
		actionBar1.setHomeButtonEnabled(true);
		getActionBar().setIcon(
				   new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		
		
		
		
		
		setContentView(R.layout.album_activity_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);

		overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);

		gridView = (GridView) findViewById(R.id.list);

		

		adapter = new CustomListAdapter(this, movieList);
		gridView.setAdapter(adapter);
		
		

		
		
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Moviealbum m5 = movieList.get(position);

				Intent i = new Intent(getApplicationContext(),album.
						FullImageActivity.class);

				i.putExtra("movieobject", m5);
				startActivity(i);
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		

		pDialog = new ProgressDialog(this);
		// Showing progress dialog before making http request
		pDialog.setMessage("Loading...");
		pDialog.show();

		// changing action bar color
		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#1b1b1b")));

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
								movie.setTitle(obj.getString("no"));
								movie.setThumbnailUrl(obj.getString("alinks"));

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
		switch (v.getId()) {

		case R.id.bottom_button:

			Intent bot = new Intent(album.MainActivity.this,
					com.example.hive.MainActivity.class);
			startActivity(bot);

			break;

		}

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
