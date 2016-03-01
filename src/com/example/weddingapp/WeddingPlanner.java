package com.example.weddingapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.eventassociate.weddingapp.R;

public class WeddingPlanner extends Activity {
	
	TextView WP1; 
	ImageView Wplan;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.weddingplanner);
		
		WP1 = (TextView) findViewById(R.id.weddingplannertext);
		Wplan = (ImageView) findViewById(R.id.imageAce);
		
		Typeface weddplan = Typeface.createFromAsset(getAssets(),"fonts/Fabrica.otf");
		WP1.setTypeface(weddplan);
		
		
		 getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		
		
		
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
