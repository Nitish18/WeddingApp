package com.example.weddingapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.eventassociate.weddingapp.R;
import com.joooonho.SelectableRoundedImageView;
import com.special.ResideMenu.ResideMenu;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class HomeFragment extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;
    ImageView jasonimage;
    TextView Shimmer;
    
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.home, container, false);
        setUpViews();
        
        
        LinearLayout rlayout = (LinearLayout) parentView.findViewById(R.id.l1);
        
        rlayout.setOnClickListener(onClickListener);
        
        
        
       
       
 
        SelectableRoundedImageView iv1 = (SelectableRoundedImageView) parentView.findViewById(R.id.imageView_oval);
        iv1.setScaleType(ScaleType.FIT_XY);
        
       
        
        
        
        
        
        SelectableRoundedImageView iv2 = (SelectableRoundedImageView) parentView.findViewById(R.id.imageView_oval2);
        iv2.setScaleType(ScaleType.FIT_XY);
        
       
        
        
        SelectableRoundedImageView iv3 = (SelectableRoundedImageView) parentView.findViewById(R.id.imageView_oval3);
        iv3.setScaleType(ScaleType.FIT_XY);
        
        
        
        
        
        Shimmer = (TextView) parentView.findViewById(R.id.shimmer);
        
        Typeface type4321 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/AlexBrush-Regular.ttf"); 
	     Shimmer.setTypeface(type4321);
        
        Animation shake = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.push_up_in);
		Shimmer.startAnimation(shake);
		
		
		Shimmer.postDelayed(new Runnable() {
			public void run() {
				Animation shake2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.push_down_out);
				Shimmer.startAnimation(shake2);
			    Shimmer.setVisibility(View.INVISIBLE);
			}
			}, 4000);
		
        
        
        
        
        
        
        return parentView;
    }
    
    
    View.OnClickListener onClickListener= new View.OnClickListener() {
        public void onClick(View v) {
        	
        	
        	resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
        	
        	
        	
        	
        	
        	
          // it was the 1st button
        }
      };

   




	private void setUpViews() {
        MainActivity parentActivity = (MainActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();

       

       
    }

}
