package aboutuscontent;

import java.io.File;
import java.io.FileOutputStream;

import com.eventassociate.weddingapp.R;
import com.meg7.samples.SamplesActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Aboutus_story extends Activity {

	ImageView Holder1, Holder2, imgholder1, imgholder2 , Holder3 , imgholder3;

	TextView Textof1, Textof2, Textof3;

	ProgressBar pg1, pg2;

	String bridenamelast, bridedisclast, bridefamilylast, bridephotolast;

	String groomnamelast, groomdisclast, groomfamilylast, groomphotolast;

	// String currentUrl =
	// "http://eventassociate.com/wedding/android_aboutus_photos/bride1.jpg";

	// String currentUrl2 =
	// "http://eventassociate.com/wedding/android_aboutus_photos/groom1.jpg";

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
		
		setContentView(R.layout.aboutus_story);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);

	

		Holder1 = (ImageView) findViewById(R.id.imgholder1);
		Holder2 = (ImageView) findViewById(R.id.imgholder2);
		Holder3 = (ImageView) findViewById(R.id.imgholder3);
		imgholder1 = (ImageView) findViewById(R.id.imageofholder1);
		imgholder2 = (ImageView) findViewById(R.id.imageofholder2);
		imgholder3 = (ImageView) findViewById(R.id.imageofholder3);
		
		
		pg1 = (ProgressBar) findViewById(R.id.loadingimg1);
		pg2 = (ProgressBar) findViewById(R.id.loadingimg2);

		Textof1 = (TextView) findViewById(R.id.textof1);
		Textof2 = (TextView) findViewById(R.id.textof2);
		Textof3 = (TextView) findViewById(R.id.textof3);

		Typeface for1 = Typeface.createFromAsset(getAssets(),
				"fonts/AlexBrush-Regular.ttf");

		Textof1.setTypeface(for1);

		Textof2.setTypeface(for1);

		Textof3.setTypeface(for1);

		// getting data from mainactivity

		Bundle abd = getIntent().getExtras();

		bridenamelast = abd.getString("weddbridename");
		bridedisclast = abd.getString("weddbridedisc");
		bridefamilylast = abd.getString("weddbridefamily");
		bridephotolast = abd.getString("weddbridephoto");

		groomnamelast = abd.getString("weddgroomname");
		groomdisclast = abd.getString("weddgroomdisc");
		groomfamilylast = abd.getString("weddgroomfamily");
		groomphotolast = abd.getString("weddgroomphoto");

		Textof1.setText("Neha");

		Textof2.setText("Nishant");
		
		Textof3.setText("Our Story");

		// for bride image

		Picasso.with(this).load(R.drawable.bride)

		.into(imgholder1, new Callback() {

			public void onSuccess() {
				pg1.setVisibility(View.GONE);
			}

			public void onError() {
				pg1.setVisibility(View.GONE);
			}
		});

		Picasso.with(this).load(R.drawable.groom)

		.into(imgholder2, new Callback() {

			public void onSuccess() {
				pg2.setVisibility(View.GONE);
			}

			public void onError() {
				pg2.setVisibility(View.GONE);
			}
		});

		imgholder1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Bundle lelobride = new Bundle();

				lelobride.putString("leloname", bridenamelast);
				lelobride.putString("lelodisc", bridedisclast);
				lelobride.putString("lelofamily", bridefamilylast);
				lelobride.putString("lelophoto", bridephotolast);

				Intent hold1 = new Intent(Aboutus_story.this, Aboutus.class);

				hold1.putExtras(lelobride);

				startActivity(hold1);

			}
		});

		imgholder2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Bundle lelogroom = new Bundle();

				lelogroom.putString("gleloname", groomnamelast);
				lelogroom.putString("glelodisc", groomdisclast);
				lelogroom.putString("glelofamily",groomfamilylast);
				lelogroom.putString("glelophoto", groomphotolast);
				

				Intent hold2 = new Intent(Aboutus_story.this,
						aboutus_groom.Aboutus_groom.class);
				
				
				hold2.putExtras(lelogroom);
				
				startActivity(hold2);

			}
		});
		
		
		imgholder3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				
				

				Intent hold3 = new Intent(Aboutus_story.this,
						bride_groom.Bridegroom.class);
				
				
				
				
				startActivity(hold3);

			}
		});
		
		
		
		
		
		
		
		
		
		

	};
	
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
