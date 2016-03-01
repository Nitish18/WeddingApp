package contacts;

import java.util.ArrayList;

import com.eventassociate.weddingapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Contact extends Activity {

	
	    ListView lv;
	    TextView ttt;
	    Context context;

	    ArrayList prgmName;
	    public static String [] prgmImages={"9873029304","9300508127","9997155660","9785700887","9506139476","9400321939","9727349081","9366390288"};
	    public static String [] prgmNameList={"Sagar Singh","Prashant Choudhary","Aditya Swaminathan","Arun Choubey","Suresh Khera","Praveen Kumar","Piyush Gupta","Nischay Mantri"};
	    public static String [] prgmNameList2={"Wedding Planner","Catering","Catering","Hospitality","Hospitality","Hospitality","Hotel Reception","Hotel Reception"};
	    
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        
	        setContentView(R.layout.contacts);

	        context=this;
	        ttt = (TextView) findViewById(R.id.TextView1);

	        lv=(ListView) findViewById(R.id.listView);
	        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages,prgmNameList2));
	        
	        
	        
	        Typeface type43212 = Typeface.createFromAsset(getAssets(),"fonts/AlexBrush-Regular.ttf"); 
		    ttt.setTypeface(type43212);
	        
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

