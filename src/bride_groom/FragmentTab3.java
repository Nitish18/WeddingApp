package bride_groom;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.eventassociate.weddingapp.R;
 
public class FragmentTab3 extends SherlockFragment {
	
	
	TextView FgR;
 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab3.xml
		View view = inflater.inflate(R.layout.bridegroom_frag3, container, false);
		
		
		FgR = (TextView) view.findViewById(R.id.FGR3);
		
		
		 Typeface fgr3 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/DroidSans.ttf"); 
	     FgR.setTypeface(fgr3);
		
		
		
		return view;
	}
 
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}
 
}