package com.example.weddingapp;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

import com.actionbarsherlock.app.ActionBar;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eventassociate.weddingapp.R;

public class RSVP extends Activity  {
	
	ActionBar actionBar;
	TextView RTXT;
	RadioGroup rgr;
	RadioButton rbb;
	Button rbt;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		

		setContentView(R.layout.rsvp);
		
		RTXT = (TextView) findViewById(R.id.rtxt);
		rbt = (Button) findViewById(R.id.mebut);
		rgr = (RadioGroup) findViewById(R.id.rgroup);
		
		
		
		 Typeface r2 = Typeface.createFromAsset(getAssets(),"fonts/ColabReg.otf"); 
	       RTXT.setTypeface(r2);
		
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// changing action bar color
				getActionBar().setBackgroundDrawable(
						new ColorDrawable(Color.parseColor("#A22B13")));

		
		
		OnClickListenerButton();
		
	}
		
	
public void OnClickListenerButton(){
	
	rbt = (Button) findViewById(R.id.mebut);
	rgr = (RadioGroup) findViewById(R.id.rgroup);
	
		
		rbt.setOnClickListener(
				
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						int selected_id = rgr.getCheckedRadioButtonId();
						rbb = (RadioButton) findViewById(selected_id);
						
						Toast.makeText(RSVP.this,"Message Sent !!",Toast.LENGTH_LONG).show();
						
					}});
				
				}

	
	
	
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

	
