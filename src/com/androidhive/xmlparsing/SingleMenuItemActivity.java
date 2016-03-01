package com.androidhive.xmlparsing;


import com.example.finalchat.MainActivity_chat;
import com.eventassociate.weddingapp.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SingleMenuItemActivity  extends Activity implements OnClickListener {
	
	
	Button reachbutton;
	
	
	
	String final_lat;
	String final_long;
	String final_name;
	
	Button navigationbutton;
	
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.reach_single_list_item);
        
        reachbutton = (Button) findViewById(R.id.reach_button);
        navigationbutton = (Button) findViewById(R.id.navigation_button);
        
        reachbutton.setOnClickListener(this);
        navigationbutton.setOnClickListener(this);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
       
        
       
     // get intent data

     		Intent i = getIntent();

     		Moviealbum myParcelableObject = (Moviealbum) i.getParcelableExtra("movieobject");

     		String name = myParcelableObject.getTitle();
     		String meralat = myParcelableObject.getYear();
     		String meralong = myParcelableObject.getDay();
        
        
        
        
        
      
        
        final_lat = meralat;
        final_long = meralong;
        final_name=name;
        
        
       
       
        
        
       
        
        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
       
        
        lblName.setText(name);
        
    }
	@Override
	public void onClick(View v) {
		
		switch (v.getId()){
		
		case R.id.reach_button:
			
			
			
			//create a bundle object to store the values
		      Bundle bundle = new Bundle();
		      
			//assign the values (key, value pairs)
		      bundle.putString("key_lat",final_lat);
		      bundle.putString("key_long",final_long);
		      bundle.putString("key_name",final_name);
		      
		      
		      //create the intent
		      //this is different than we did it before
		      Intent i = new Intent(SingleMenuItemActivity.this,com.example.weddingapp.Howtoreach.class);
		      //assign the bundle to the intent
		      i.putExtras(bundle);
		      //start the new activity
		      startActivity(i);
			
			
			
			
			
			
			break;
			
			
			
		case R.id.navigation_button:
			
			
			String url = "http://maps.google.com/maps?&daddr=" + final_lat + "," + final_long;
			Intent gmap = new Intent(Intent.ACTION_VIEW);
			gmap.setData(Uri.parse(url));
			startActivity(gmap);
			
			
			
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
