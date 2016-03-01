package aboutuscontent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.eventassociate.weddingapp.R;
 
public class FragmentTab2 extends SherlockFragment {
 
	
	 String mfamily,vehicleNumber2;
	 TextView FRTXT;
	 
	 
	 public FragmentTab2(String vehicleNumber2) {
	       
			this.mfamily = vehicleNumber2;
		       
		    }
	
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		
		View view = inflater.inflate(R.layout.fragmenttab2, container, false);
		
		FRTXT = (TextView) view.findViewById(R.id.frag2txt);
		
		
		
		
		
	
		
		
		return view;
	}
 
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}
 
}
