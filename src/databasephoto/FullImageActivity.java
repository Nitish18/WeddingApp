package databasephoto;

import java.io.InputStream;
import java.net.URL;

import com.eventassociate.weddingapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class FullImageActivity extends Activity {

	
	ImageView img;
	Bitmap bitmap;
    ProgressBar pBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		            WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
		
		setContentView(R.layout.full_image);


		img = (ImageView)findViewById(R.id.img);
		
		pBar = (ProgressBar) findViewById(R.id.progressBaar);
		

		// get intent data

		Intent i = getIntent();

		Movie myParcelableObject = (Movie) i.getParcelableExtra("movieobject");

		String alp = myParcelableObject.getThumbnailUrl();
		
		
		
		Picasso.with(getApplicationContext())
		  .load(alp)
		  .resize(500,500)
		  .centerCrop()
		  .into(img, new Callback() {

	          @Override
	          public void onSuccess() {
	            pBar.setVisibility(View.GONE);
	          }

	          @Override
	          public void onError() {
	        	  
	        	  
	        	  Toast.makeText(getApplicationContext(), "There was error!",Toast.LENGTH_LONG).show();
	        	  

	          }
	        });

		
		
			

}
	
	
	
}