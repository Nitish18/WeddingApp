package com.example.weddingapp;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import login.AppControllerjson;








import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.eventassociate.weddingapp.R;
import com.meg7.widget.CircleImageView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Splash extends Activity implements OnClickListener {
	
	
	
	TextView ace1,ace2,ace3;
	
	// Progress dialog

		
		
		private ProgressBar PROBAR;
	
	
	
	
	
	Button button_without_login;
	
	private String bridename, herfamily, herdiscription, herfinalphoto;

	private String groomname, hisfamily, hisdiscription, hisfinalphoto;
	
	
	private String urlJsonArry = "http://eventassociate.com/wedding/brideaboutus.php";

	private static String TAG = Splash.class.getSimpleName();
	
	
	
		
		
		// temporary string to show the parsed response
		private String eventbridename, eventbridediscription, eventbridefamily,
				eventbridephoto;

		private String eventgroomname, eventgroomdiscription, eventgroomfamily,
				eventgroomphoto;
		
		static Splash activityA;
		
		
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
		
        setContentView(R.layout.splash);
        
        activityA = this;
        
        
       
        
        PROBAR = (ProgressBar) findViewById(R.id.proBar);
        
        
        ace1 = (TextView) findViewById(R.id.shim1);
        ace2 = (TextView) findViewById(R.id.shim2);
        ace3 = (TextView) findViewById(R.id.shim3);
        
        
               
        Typeface AC1 = Typeface.createFromAsset(getAssets(),"fonts/AlexBrush-Regular.ttf"); 
	     ace1.setTypeface(AC1);
        
        
        
	       Typeface AC2 = Typeface.createFromAsset(getAssets(),"fonts/AlexBrush-Regular.ttf"); 
	       ace2.setTypeface(AC2);
        
        
        
	       Typeface AC3 = Typeface.createFromAsset(getAssets(),"fonts/AlexBrush-Regular.ttf"); 
	       ace3.setTypeface(AC3);
		
		
        
        
      //  Acebar = (ProgressBar) findViewById(R.id.acebar);
        
        button_without_login = (Button) findViewById(R.id.without_login);
        button_without_login.setOnClickListener(this);
        
       
        
       
	       
	       
	      
			

        
      //http request for google map update.
	       
	       
	       
	    makeJsonArrayRequest();
	    
  	
		
	}
	
	
	public static Splash getInstance(){
		   return   activityA;
		 }
	
	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.without_login:

			Bundle info = new Bundle();
			info.putString("NAME", eventbridename);
			info.putString("DISCRIPTION", eventbridediscription);
			info.putString("FAMILY", eventbridefamily);
			info.putString("PIC", eventbridephoto);

			info.putString("GNAME", eventgroomname);
			info.putString("GDISCRIPTION", eventgroomdiscription);
			info.putString("GFAMILY", eventgroomfamily);
			info.putString("GPIC", eventgroomphoto);

			Intent m1 = new Intent(Splash.this,
					MainActivity.class);

			m1.putExtras(info);

			startActivity(m1);
			
			
			
			
			
			
			
			

			break;

		}

	
	
	}
	
	
	
	
	
	
	
	
	
	private void makeJsonArrayRequest() {

		
		
		
		
		JsonArrayRequest req = new JsonArrayRequest(urlJsonArry,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.d(TAG, response.toString());

						try {
							// Parsing json array response
							// loop through each json object
							eventbridename = "";
							eventbridediscription = "";
							eventbridefamily = "";
							eventbridephoto = "";

							eventgroomname = "";
							eventgroomdiscription = "";
							eventgroomfamily = "";
							eventgroomphoto = "";

							for (int i = 0; i < response.length(); i++) {

								JSONObject person = (JSONObject) response
										.get(i);

								String bridename = person.getString("bname");
								String herdiscription = person
										.getString("discription");
								String herfamily = person
										.getString("familyDiscription");
								String herphoto = person.getString("photolink");

								String groomname = person.getString("gname");
								String hisdiscription = person
										.getString("gdiscription");
								String hisfamily = person
										.getString("gfamilydiscription");
								String hisphoto = person
										.getString("gphotolink");

								String herfinalphoto = "http://eventassociate.com/wedding/"
										+ herphoto;

								String hisfinalphoto = "http://eventassociate.com/wedding/"
										+ hisphoto;

								eventbridename = bridename;
								eventbridediscription = herdiscription;
								eventbridefamily = herfamily;
								eventbridephoto = herfinalphoto;

								eventgroomname = groomname;
								eventgroomdiscription = hisdiscription;
								eventgroomfamily = hisfamily;
								eventgroomphoto = hisfinalphoto;

							}

						} catch (JSONException e) {
							e.printStackTrace();
							Toast.makeText(getApplicationContext(),"You are not connected to Internet", Toast.LENGTH_LONG).show();
						}
						
						
						
						
						PROBAR.setVisibility(View.INVISIBLE);
						
						
						
						
						 button_without_login.setVisibility(View.VISIBLE);
						 
						 Animation shake = AnimationUtils.loadAnimation(Splash.this, R.anim.push_up_in);
						 button_without_login.startAnimation(shake);
						
						
						
						
						

						
					}
					
					
					
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						VolleyLog.d(TAG, "Error: " + error.getMessage());
						Toast.makeText(getApplicationContext(),
								"Internet Connection Problem", Toast.LENGTH_SHORT).show();
						
				
						PROBAR.setVisibility(View.INVISIBLE);
						
						 button_without_login.setVisibility(View.VISIBLE);
						 Animation shake = AnimationUtils.loadAnimation(Splash.this, R.anim.push_up_in);
						 button_without_login.startAnimation(shake);
						
						
					}
				});
		
		


		// Adding request to request queue
		AppControllerjson.getInstance().addToRequestQueue(req);
		
		
		
	 
		
		
	}	

}
	
	

	
	
	
	
	
	


