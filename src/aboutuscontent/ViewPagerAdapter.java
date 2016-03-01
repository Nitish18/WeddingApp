package aboutuscontent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	
	
	String mvehicleNumber,mfamily,mphoto;
	
	
	public ViewPagerAdapter(FragmentManager fm,String fbdisc,String fbf,String fbp) {
		super(fm);
		this.mvehicleNumber = fbdisc;
		this.mfamily = fbf;
		this.mphoto = fbp;
		// TODO Auto-generated constructor stub
	}

	
	
	

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 2;
	
	
	
	
	
	
	
	
	

	
	

	
	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {

		// Open FragmentTab1.java
		case 0:
			FragmentTab1 fragmenttab1 = new FragmentTab1(mvehicleNumber,mphoto);
			return new FragmentTab1(mvehicleNumber,mphoto);

		// Open FragmentTab2.java
		case 1:
			FragmentTab2 fragmenttab2 = new FragmentTab2(mfamily);
			return new FragmentTab2(mfamily);

		// Open FragmentTab3.java
		
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

}