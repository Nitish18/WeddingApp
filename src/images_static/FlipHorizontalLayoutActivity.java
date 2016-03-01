/*
Copyright 2012 Aphid Mobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package images_static;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;

import com.eventassociate.weddingapp.R;
import com.aphidmobile.flip.FlipViewController;

import images_static.TravelAdapter;

import com.eventassociate.weddingapp.R;

public class FlipHorizontalLayoutActivity extends Activity {

  private FlipViewController flipView;
  

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    
 // changing action bar color
 		getActionBar().setBackgroundDrawable(
 				new ColorDrawable(Color.parseColor("#800000")));

   
  
    flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);

    flipView.setAdapter(new TravelAdapter(this));
    

    setContentView(flipView);
    
    ActionBar actionBar1 = getActionBar();
	actionBar1.setHomeButtonEnabled(true);
	getActionBar().setIcon(
			   new ColorDrawable(getResources().getColor(android.R.color.transparent)));
	
	
	
    
    
    
    
    ActionBar actionBar = getActionBar();
    actionBar.setDisplayOptions(actionBar.getDisplayOptions()
            | ActionBar.DISPLAY_SHOW_CUSTOM);
    ImageView imageView = new ImageView(actionBar.getThemedContext());
    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    imageView.setImageResource(R.drawable.gesture);
    
    ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT
                    | Gravity.CENTER_VERTICAL);
    layoutParams.rightMargin = 30;
    imageView.setLayoutParams(layoutParams);
    actionBar.setCustomView(imageView);
    
    
    getActionBar().setDisplayHomeAsUpEnabled(true);
    
    
  }

  @Override
  protected void onResume() {
    super.onResume();
    flipView.onResume();
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

  @Override
  protected void onPause() {
    super.onPause();
    flipView.onPause();
  }
}
