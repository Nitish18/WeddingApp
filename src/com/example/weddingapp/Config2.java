package com.example.weddingapp;

public interface Config2 {

	
	// CONSTANTS
	static final String YOUR_SERVER_URL =  "http://eventassociate.com/wedding/gcm_server_files/register.php";
	// YOUR_SERVER_URL : Server url where you have placed your server files
    // Google project id
    static final String GOOGLE_SENDER_ID = "25421319233";  // Place here your Google project id

    /**
     * Tag used on log messages.
     */
    static final String TAG = "GCM Android Example";

    static final String DISPLAY_MESSAGE_ACTION =
            "com.example.weddingapp.DISPLAY_MESSAGE";

    static final String EXTRA_MESSAGE = "message";
		
	
}
