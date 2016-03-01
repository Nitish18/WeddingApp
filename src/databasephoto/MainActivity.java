package databasephoto;

import databasephoto.CustomListAdapter;
import databasephoto.AppController;
import databasephoto.Movie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.example.hive.UploadActivity;
import com.eventassociate.weddingapp.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;


public class MainActivity extends Activity implements OnClickListener {
	// Log tag
	private static final String TAG = MainActivity.class.getSimpleName();

	// Movies json url
	private static final String url = "http://eventassociate.com/wedding/photomania";
	private ProgressDialog pDialog;
	private List<Movie> movieList = new ArrayList<Movie>();
	private PullToRefreshGridView mPullRefreshGridView;
	private GridView gridView;
	private CustomListAdapter adapter;
	ImageButton blackcapture;
	private static int RESULT_LOAD_IMAGE = 1;
	String picturePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        
        
               
		
		setContentView(R.layout.gallary_activity_main);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		// changing action bar color
				getActionBar().setBackgroundDrawable(
						new ColorDrawable(Color.parseColor("#A22B13")));

		
		
		ActionBar actionBar1 = getActionBar();
		actionBar1.setHomeButtonEnabled(true);
		getActionBar().setIcon(
				   new ColorDrawable(getResources().getColor(android.R.color.transparent)));  
		
		
		mPullRefreshGridView = (PullToRefreshGridView) findViewById(R.id.list);
		gridView = mPullRefreshGridView.getRefreshableView();
		
		gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		 
		
		
		
		mPullRefreshGridView.setOnRefreshListener(new OnRefreshListener2<GridView>() {

			@Override
			public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
				
				
				adapter.notifyDataSetChanged();
				gridView.setAdapter(adapter);
				gridView.invalidateViews();
		       
				mPullRefreshGridView.onRefreshComplete();
				
			}

			@Override
			public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
				
			adapter.notifyDataSetChanged();
			gridView.setAdapter(adapter);
			gridView.invalidateViews();
				mPullRefreshGridView.onRefreshComplete();
			}

		});
		
		
		
		

		

		blackcapture = (ImageButton) findViewById(R.id.bottom_button);
		blackcapture.setOnClickListener(this);

		adapter = new CustomListAdapter(this, movieList);
		gridView.setAdapter(adapter);

		
		
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Movie m5 = movieList.get(position);

				Intent i = new Intent(getApplicationContext(),
						FullImageActivity.class);

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
								Movie movie = new Movie();
								movie.setTitle(obj.getString("No"));
								movie.setThumbnailUrl(obj.getString("flinks"));

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

	
	

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.bottom_button:

			
			AlertDialog alertDialog = new AlertDialog.Builder(
                    MainActivity.this).create();
			
			 // Setting Dialog Title
	        alertDialog.setTitle("Upload Photo");
	        
	        // Setting Dialog Message
	        alertDialog.setMessage("Upload using :-");
	 
	        // Setting Icon to Dialog
	        alertDialog.setIcon(R.drawable.camera);
	        
	        
	        // Setting OK Button
	        alertDialog.setButton("Camera", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                // Write your code here to execute after dialog closed
	               Intent o1 = new Intent(MainActivity.this,com.example.hive.MainActivity.class);
	               startActivity(o1);
	                	
	                	
	                	
	                }
	        });
	        
	        
	        
	     // Setting OK Button
	        alertDialog.setButton2("Memory", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                // Write your code here to execute after dialog closed
	                	Intent ib = new Intent(
	                            Intent.ACTION_PICK,
	                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	                     
	                    startActivityForResult(ib, RESULT_LOAD_IMAGE);
	                	
	                	
	                }
	        });
	        
	        
	        
	        
	        
	        
	 
	        // Showing Alert Message
	        alertDialog.show();
			
			
			
			
			
			
			
			
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

	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            
            
            
            
            cursor.close();
            
            
            Intent i = new Intent(databasephoto.MainActivity.this, com.example.hive.UploadActivity.class);
            i.putExtra("filePath", picturePath);
            
            startActivity(i);
           
            
            
       
            
             
           
         
        }
     
     
	}
	
	
	
}
