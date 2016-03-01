package com.example.finalchat;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.eventassociate.weddingapp.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class MainActivity_chat extends ListActivity {

	// TODO: change this to your own Firebase URL
	private static final String FIREBASE_URL = "https://shining-torch-4420.firebaseio.com";

	private String mUsername;
	private Firebase mFirebaseRef;
	private ValueEventListener mConnectedListener;
	private ChatListAdapter mChatListAdapter;
	String ram ;
	String shyam ;
	String gprofilephoto;
	String fbprofilephoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		setContentView(R.layout.activity_chat);
		overridePendingTransition(R.anim.ace_in, R.anim.ace_out);

		// Removing app icon
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));

		Bundle bundle = getIntent().getExtras();

		String gprofilephoto = bundle.getString("prof");
		
		
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		 
		
		
		
		
		

		// Action bar image.................................

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayOptions(actionBar.getDisplayOptions()
				| ActionBar.DISPLAY_SHOW_CUSTOM);
		ImageView imageView = new ImageView(actionBar.getThemedContext());
		imageView.setScaleType(ImageView.ScaleType.CENTER);

		
	  
			Picasso.with(getBaseContext()).load(gprofilephoto).resize(50, 50)

			.into(imageView);

	  

		ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.WRAP_CONTENT,
				ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT
						| Gravity.CENTER_VERTICAL);
		layoutParams.rightMargin = 40;
		imageView.setLayoutParams(layoutParams);
		actionBar.setCustomView(imageView);
		
		
		
		
		

		// Make sure we have a mUsername
		setupUsername();

		setTitle("Chatting as " + mUsername);

		// Setup our Firebase mFirebaseRef
		mFirebaseRef = new Firebase(FIREBASE_URL).child("chat");

		// Setup our input methods. Enter key on the keyboard or pushing the
		// send button
		EditText inputText = (EditText) findViewById(R.id.messageInput);
		inputText
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView,
							int actionId, KeyEvent keyEvent) {
						if (actionId == EditorInfo.IME_NULL
								&& keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
							sendMessage();
						}
						return true;
					}
				});

		findViewById(R.id.sendButton).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						sendMessage();
					}
				});

	}

	@Override
	public void onStart() {
		super.onStart();
		// Setup our view and list adapter. Ensure it scrolls to the bottom as
		// data changes
		final ListView listView = getListView();
		// Tell our list adapter that we only want 50 messages at a time
		mChatListAdapter = new ChatListAdapter(mFirebaseRef.limit(50), this,
				R.layout.chat_message, mUsername);
		listView.setAdapter(mChatListAdapter);
		mChatListAdapter.registerDataSetObserver(new DataSetObserver() {
			@Override
			public void onChanged() {
				super.onChanged();
				listView.setSelection(mChatListAdapter.getCount() - 1);
			}
		});

		// Finally, a little indication of connection status
		mConnectedListener = mFirebaseRef.getRoot().child(".info/connected")
				.addValueEventListener(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot dataSnapshot) {
						boolean connected = (Boolean) dataSnapshot.getValue();
						if (connected) {
							Toast.makeText(MainActivity_chat.this, "Connected",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainActivity_chat.this,
									"Disconnected", Toast.LENGTH_SHORT).show();
						}
					}

					@Override
					public void onCancelled(FirebaseError firebaseError) {
						// No-op
					}
				});
	}

	@Override
	public void onStop() {
		super.onStop();
		mFirebaseRef.getRoot().child(".info/connected")
				.removeEventListener(mConnectedListener);
		mChatListAdapter.cleanup();
	}

	private void setupUsername() {

		Bundle bundle = getIntent().getExtras();

		ram = bundle.getString("username_chat");

		// get the values out by key

		
		
		
		Toast.makeText(getApplicationContext(), ram, Toast.LENGTH_LONG).show();
		
			mUsername = ram;

		

	}

	private void sendMessage() {
		EditText inputText = (EditText) findViewById(R.id.messageInput);
		String input = inputText.getText().toString();
		if (!input.equals("")) {
			// Create our 'model', a Chat object
			Chat chat = new Chat(input, mUsername);
			// Create a new, auto-generated child of that chat location, and
			// save our chat data there
			mFirebaseRef.push().setValue(chat);
			inputText.setText("");
		}

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

}
