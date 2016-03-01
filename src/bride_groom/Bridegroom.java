package bride_groom;


import bride_groom.ViewPagerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.MenuItem;
import com.eventassociate.weddingapp.R;

public class Bridegroom extends SherlockFragmentActivity {// Declare Variables
	
	
	
	
	ActionBar mActionBar;
	ViewPager mPager;
	Tab tab;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.bridegroom);
		
		 getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		// Activate Navigation Mode Tabs
				mActionBar = getSupportActionBar();
				mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

				// Locate ViewPager in activity_main.xml
				mPager = (ViewPager) findViewById(R.id.pager);

				// Activate Fragment Manager
				FragmentManager fm = getSupportFragmentManager();

				// Capture ViewPager page swipes
				ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						super.onPageSelected(position);
						// Find the ViewPager Position
						mActionBar.setSelectedNavigationItem(position);
					}
				};

				mPager.setOnPageChangeListener(ViewPagerListener);
				// Locate the adapter class called ViewPagerAdapter.java
				ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(fm);
				
				
				
				
				viewpageradapter = new ViewPagerAdapter(getSupportFragmentManager());
				
				
				
				
				
				
				// Set the View Pager Adapter into ViewPager
				mPager.setAdapter(viewpageradapter);
				
				
				

				// Capture tab button clicks
				ActionBar.TabListener tabListener = new ActionBar.TabListener() {

					@Override
					public void onTabSelected(Tab tab, FragmentTransaction ft) {

						// Pass the position on tab click to ViewPager
						mPager.setCurrentItem(tab.getPosition());
					}

					@Override
					public void onTabUnselected(Tab tab, FragmentTransaction ft) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onTabReselected(Tab tab, FragmentTransaction ft) {
						// TODO Auto-generated method stub
					}
				};

				// Create first Tab
				tab = mActionBar.newTab().setText("First Meeting")
						.setTabListener(tabListener);
				mActionBar.addTab(tab);

				// Create second Tab
				tab = mActionBar.newTab().setText("First Date")
						.setTabListener(tabListener);
				mActionBar.addTab(tab);

				
				// Create second Tab
				tab = mActionBar.newTab().setText("The Proposal")
						.setTabListener(tabListener);
				mActionBar.addTab(tab);


		
		
		
		
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
