package com.meg7.samples;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eventassociate.weddingapp.R;
import com.meg7.widget.CustomShapeImageView;
import com.meg7.widget.CustomShapeSquareImageView;

import java.util.ArrayList;
import java.util.List;

public class SamplesActivity extends Activity {

	
	
	ImageView Cirimage;
	TextView Tap;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
Cirimage = (ImageView) findViewById(R.id.golimage);
Tap = (TextView) findViewById(R.id.tap);



Typeface type5 = Typeface.createFromAsset(getAssets(),"fonts/AlexBrush-Regular.ttf"); 
Tap.setTypeface(type5);






Cirimage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v){
          
    	Intent sam = new Intent(SamplesActivity.this,aboutuscontent.Aboutus.class);
    	startActivity(sam);
    	
    	
    	
    }
 });











       
    }
    
    
    
    
    
    
    
    

    private class SvgImagesAdapter extends BaseAdapter {
        private List<Integer> mSvgRawResourceIds = new ArrayList<Integer>();

        private Context mContext;

       

        @Override
        public int getCount() {
            return mSvgRawResourceIds.size();
        }

        @Override
        public Integer getItem(int i) {
            return mSvgRawResourceIds.get(i);
        }

        @Override
        public long getItemId(int i) {
            return mSvgRawResourceIds.get(i);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return new CustomShapeSquareImageView(mContext, R.drawable.sample_1,CustomShapeImageView.Shape.SVG, getItem(i));// It is just a sample ;)
        }

    }

}
