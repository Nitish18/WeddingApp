package accomodation;


import android.app.ActionBar.LayoutParams;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.eventassociate.weddingapp.R;

public class Accomomain extends Activity {

	
	ImageView IMGACCOMO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		 
		 ActionBar actionBar1 = getActionBar();
			actionBar1.setHomeButtonEnabled(true);
			getActionBar().setIcon(
					   new ColorDrawable(getResources().getColor(android.R.color.transparent)));
			 actionBar1.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A22B13")));
		 
		
		
		setContentView(R.layout.activity_accomo);
		
		IMGACCOMO = (ImageView) findViewById(R.id.imageaccomo);
		
		
		
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
