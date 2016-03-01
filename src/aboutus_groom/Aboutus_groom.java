package aboutus_groom;

import aboutuscontent.ViewPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.eventassociate.weddingapp.R;

public class Aboutus_groom extends SherlockFragmentActivity {
	
	
	// Declare Variables
		ActionBar mActionBar;
		ViewPager mPager;
		Tab tab;
		
		String gfbname, gfbdisc, gfbf, gfbp;
		
		
	 
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			
			
			
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
			
			// Get the view from activity_main.xml
			setContentView(R.layout.aboutus_groom);
			
			getActionBar().setDisplayHomeAsUpEnabled(true);
			
			
			
			
			
			
			// getting info from Aboutus_story

			Bundle lelogroom = getIntent().getExtras();

			gfbname = lelogroom.getString("gleloname");
			gfbdisc = lelogroom.getString("glelodisc");
			gfbf = lelogroom.getString("glelofamily");
			gfbp = lelogroom.getString("glelophoto");

			
			
			
			
			
			
			
			
			
	 
			// Activate Navigation Mode Tabs
			mActionBar = getSupportActionBar();
			mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	 
			// Locate ViewPager in activity_main.xml
			mPager = (ViewPager) findViewById(R.id.pager_groom);
	 
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
			ViewPagerAdapter_groom viewpageradapter = new ViewPagerAdapter_groom(fm,gfbdisc,gfbf,gfbp);
			
			
			
			
			viewpageradapter = new ViewPagerAdapter_groom(getSupportFragmentManager(),gfbdisc,gfbf,gfbp);
			
			
			
			
			
			
			
			
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
			tab = mActionBar.newTab().setText("Nishant").setTabListener(tabListener);
			mActionBar.addTab(tab);
	 
			// Create second Tab
			tab = mActionBar.newTab().setText("His Interest").setTabListener(tabListener);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
