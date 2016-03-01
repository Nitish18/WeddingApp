package bride_groom;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.eventassociate.weddingapp.R;
 
public class FragmentTab2 extends SherlockFragment {
 
	
	 
	 TextView FRTXT;
	 
	 
	 public FragmentTab2() {
	       
			
		       
		    }
	
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		
		View view = inflater.inflate(R.layout.bridegroom_frag2, container, false);
		
		FRTXT = (TextView) view.findViewById(R.id.FGR2);
		
		
		
		 Typeface fgr2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/DroidSans.ttf"); 
	     FRTXT.setTypeface(fgr2);
		
	
		
		
		return view;
	}
 
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}
 
}
