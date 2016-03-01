package aboutuscontent;

import android.app.ProgressDialog;
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

	ImageView brideimage1, brideimage2;
	TextView bridetext;
	String mvehicleNumber, vehicleNumber, herpicture, mphoto;
	

	public FragmentTab1(String vehicleNumber, String herpicture) {

		this.mvehicleNumber = vehicleNumber;
		this.mphoto = herpicture;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml

		View view = inflater.inflate(R.layout.fragmenttab1, container, false);
		
		

		brideimage1 = (ImageView) view.findViewById(R.id.headbride);
		brideimage2 = (ImageView) view.findViewById(R.id.golimagebride);
		
		
		
		
		
		

		 Picasso.with(getActivity()).load(R.drawable.bride)

		.into(brideimage2, new Callback() {

			public void onSuccess() {
			
			}

			public void onError() {
			
			}
		});
		
		
		
		
		
		

		bridetext = (TextView) view.findViewById(R.id.bridetext);
		bridetext.setMovementMethod(new ScrollingMovementMethod());
	

		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);

	}

}