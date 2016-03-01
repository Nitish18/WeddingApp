package bride_groom;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	
	
	String mvehicleNumber,mfamily,mphoto;
	
	
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		
		// TODO Auto-generated constructor stub
	}

	
	
	

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 3;
	
	
	
	
	
	
	
	
	

	
	

	
	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {

		// Open FragmentTab1.java
		case 0:
			FragmentTab1 fragmenttab1 = new FragmentTab1();
			return new FragmentTab1();

		// Open FragmentTab2.java
		case 1:
			FragmentTab2 fragmenttab2 = new FragmentTab2();
			return new FragmentTab2();

		// Open FragmentTab3.java
		case 2:
			FragmentTab3 fragmenttab3 = new FragmentTab3();
			return new FragmentTab3();
		
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

}