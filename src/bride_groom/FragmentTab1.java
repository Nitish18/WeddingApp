package bride_groom;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.eventassociate.weddingapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FragmentTab1 extends SherlockFragment {

	
	TextView bridetext;
	
	

	public FragmentTab1() {

		

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml

		View view = inflater.inflate(R.layout.bridegroom_frag1, container, false);
		
		

		bridetext = (TextView) view.findViewById(R.id.FGR1);
		
		bridetext.setMovementMethod(new ScrollingMovementMethod());
		
		
		 Typeface fgr1 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/DroidSans.ttf"); 
	     bridetext.setTypeface(fgr1);
		
		
		
		
		
		
	

		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);

	}

}