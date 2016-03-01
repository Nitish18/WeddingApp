package aboutus_groom;

import aboutuscontent.FragmentTab1;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter_groom extends FragmentPagerAdapter {
	
	
	String gmvehicleNumber,gmfamily,gmphoto;
	
	
	
	public ViewPagerAdapter_groom(FragmentManager fm,String gfbdisc,String gfbf,String gfbp) {
		super(fm);
		this.gmvehicleNumber = gfbdisc;
		this.gmfamily = gfbf;
		this.gmphoto = gfbp;
		// TODO Auto-generated constructor stub
	}
	
	
	

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 3;

	

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {

		// Open FragmentTab1.java
		case 0:
			FragmentTab1_groom fragmenttab1 = new FragmentTab1_groom(gmvehicleNumber,gmphoto);
			return new FragmentTab1_groom(gmvehicleNumber,gmphoto);
		// Open FragmentTab2.java
		case 1:
			FragmentTab2_groom fragmenttab2 = new FragmentTab2_groom();
			return fragmenttab2;

		// Open FragmentTab3.java
		case 2:
			FragmentTab3_groom fragmenttab3 = new FragmentTab3_groom();
			return fragmenttab3;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

}
