package com.example.weddingapp;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.eventassociate.weddingapp.R;
import com.example.weddingapp.HomeFragment;
import com.example.weddingapp.MainActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		View.OnClickListener {

	private ResideMenu resideMenu;
	private MainActivity mContext;
	
	private ResideMenuItem itemEvents;
	private ResideMenuItem itemAlbum;
	private ResideMenuItem itemAbout;
	private ResideMenuItem itemChat;
	private ResideMenuItem itemGallery;
	private ResideMenuItem itemMap;
	private ResideMenuItem itemAccomodation;
	private ResideMenuItem itemContact;
	private ResideMenuItem itemPlanner;
	private ResideMenuItem itemRSVP;
	

	Button Button1, Button2, Button3, Button4, Button5, Button6;

	String wbridename, wbridediscription, wbridefamily, wbridephoto;
	String wgroomname, wgroomdiscription, wgroomfamily, wgroomphoto;
	
	TextView Itsmy;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		 
		 
		 
		 
		setContentView(R.layout.loadscreen);
		
		
		
		
		Splash.getInstance().finish(); 
		
		
		

		Bundle info = getIntent().getExtras();

		wbridename = info.getString("NAME");

		wbridediscription = info.getString("DISCRIPTION");

		wbridefamily = info.getString("FAMILY");

		wbridephoto = info.getString("PIC");

		wgroomname = info.getString("GNAME");

		wgroomdiscription = info.getString("GDISCRIPTION");

		wgroomfamily = info.getString("GFAMILY");

		wgroomphoto = info.getString("GPIC");
		
		

		mContext = this;
		setUpMenu();
		if (savedInstanceState == null)
			changeFragment(new HomeFragment());
	}

	private void setUpMenu() {

		// attach to current activity;
		resideMenu = new ResideMenu(this);
		resideMenu.setBackground(R.drawable.menu_background);
		resideMenu.attachToActivity(this);
		resideMenu.setMenuListener(menuListener);
		// valid scale factor is between 0.0f and 1.0f. leftmenu'width is
		// 150dip.
		resideMenu.setScaleValue(0.6f);
		
	

		// create menu items;
		
		itemEvents = new ResideMenuItem(this, R.drawable.ph1, "Events");
		itemAlbum = new ResideMenuItem(this, R.drawable.ph2, "Album");
		itemAbout = new ResideMenuItem(this, R.drawable.ph3, "Couple");
		itemChat = new ResideMenuItem(this, R.drawable.ph4, "Chat");
		itemGallery = new ResideMenuItem(this, R.drawable.ph5, "Gallery");
		itemMap = new ResideMenuItem(this, R.drawable.ph6, "Reach");
		itemAccomodation = new ResideMenuItem(this, R.drawable.accomo, "Acco");
		itemContact = new ResideMenuItem(this, R.drawable.cont, "Contact");
		itemPlanner = new ResideMenuItem(this, R.drawable.plan, "Planner");
		itemRSVP = new ResideMenuItem(this, R.drawable.rsvp, "RSVP");
		
		
		itemEvents.setOnClickListener(this);
		itemAlbum.setOnClickListener(this);
		itemAbout.setOnClickListener(this);
		itemChat.setOnClickListener(this);
		itemGallery.setOnClickListener(this);
		itemMap.setOnClickListener(this);
		itemAccomodation.setOnClickListener(this);
		itemContact.setOnClickListener(this);
		itemPlanner.setOnClickListener(this);
		itemRSVP.setOnClickListener(this);

		
		resideMenu.addMenuItem(itemEvents, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemAlbum, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemAbout, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemChat, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemGallery, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemMap, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemAccomodation, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemContact, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemPlanner, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemRSVP, ResideMenu.DIRECTION_LEFT);
		
		// You can disable a direction by setting ->
		resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
		
		
		
		

		/*findViewById(R.id.title_bar_left_menu).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
					}
				});*/

	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return resideMenu.dispatchTouchEvent(ev);
	}

	@Override
	public void onClick(View view) {

	

		 if (view == itemEvents) {
			Intent x1 = new Intent(MainActivity.this, events.MainActivity.class);
			startActivity(x1);
		}

		else if (view == itemAlbum) {
			Intent x2 = new Intent(MainActivity.this,
					images_static.FlipHorizontalLayoutActivity.class);
			startActivity(x2);
		}

		else if (view == itemAbout) {
			
Bundle abd = new Bundle();
			
			
			abd.putString("weddbridename", wbridename);
			abd.putString("weddbridedisc", wbridediscription);
			abd.putString("weddbridefamily", wbridefamily);
			abd.putString("weddbridephoto", wbridephoto);
			
			
			
			abd.putString("weddgroomname", wgroomname);
			abd.putString("weddgroomdisc", wgroomdiscription);
			abd.putString("weddgroomfamily", wgroomfamily);
			abd.putString("weddgroomphoto", wgroomphoto);
			
			
			
			
			
			

			Intent i3 = new Intent(MainActivity.this,
					aboutuscontent.Aboutus_story.class);
			i3.putExtras(abd);

			startActivity(i3);
			
			
			
			

		}

		else if (view == itemChat) {
			
			Intent i6 = new Intent(MainActivity.this,
					com.example.finalchat.gpluslogin.class);
			startActivity(i6);
			
			

		}

		else if (view == itemGallery) {
			
			Intent i7 = new Intent(MainActivity.this,
					databasephoto.MainActivity.class);
			startActivity(i7);
			

		}

		else if (view == itemMap) {
			
			
			Intent i8 = new Intent(MainActivity.this,
					com.androidhive.xmlparsing.MainActivity.class);
			startActivity(i8);

		}

		
else if (view == itemAccomodation) {
			
			
			Intent i9 = new Intent(MainActivity.this,
					accomodation.Accomomain.class);
			startActivity(i9);

		}
		
		
		
else if (view == itemContact) {
	
	
	Intent i9 = new Intent(MainActivity.this,
			contacts.Contact.class);
	startActivity(i9);

}
		 
		 
else if (view == itemPlanner) {
	
	
	Intent i10 = new Intent(MainActivity.this,
			com.example.weddingapp.WeddingPlanner.class);
	startActivity(i10);

}
		
else if (view == itemRSVP) {
	
	
	Intent i11 = new Intent(MainActivity.this,
			com.example.weddingapp.RSVP.class);
	startActivity(i11);

}
		
		 
		 
		
		
		

		//resideMenu.closeMenu();
	}

	private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
		@Override
		public void openMenu() {

		}

		@Override
		public void closeMenu() {

		}
	};

	private void changeFragment(Fragment targetFragment) {
		resideMenu.clearIgnoredViewList();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.main_fragment, targetFragment, "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
	}

	// What good method is to access resideMenu？
	public ResideMenu getResideMenu() {
		return resideMenu;
	}
	
	

}
