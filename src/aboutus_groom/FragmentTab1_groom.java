package aboutus_groom;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.eventassociate.weddingapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
 
public class FragmentTab1_groom extends SherlockFragment {
 
	
	ImageView groomimage1,groomimage2;
	TextView groomtext;
	String gmvehicleNumber, gvehicleNumber, hispicture, gmphoto;
	
	
	
	public FragmentTab1_groom(String gvehicleNumber, String hispicture) {

		this.gmvehicleNumber = gvehicleNumber;
		this.gmphoto = hispicture;

	}
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragmenttab1_groom, container, false);
		
		
		groomimage1 = (ImageView) view.findViewById(R.id.headgroom);
		groomimage2 = (ImageView) view.findViewById(R.id.golimagegroom);
		
		
		
		

		 Picasso.with(getActivity()).load(R.drawable.groom)

		.into(groomimage2, new Callback() {

			public void onSuccess() {
			
			}

			public void onError() {
			
			}
		});
		
		
		
		
		
		
		groomtext = (TextView) view.findViewById(R.id.groomtext);
		groomtext.setMovementMethod(new ScrollingMovementMethod());
		
	
		
		
		
		
		
		
		return view;
	}
 
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}
 
}
