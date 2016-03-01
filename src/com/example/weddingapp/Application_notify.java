package com.example.weddingapp;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class Application_notify extends android.app.Application {

  public Application_notify() {
  }

  @Override
  public void onCreate() {
    super.onCreate();

	// Initialize the Parse SDK.
	Parse.initialize(this, "HddYU6bd3LBI48YnRg5hVxkplMBRrEVoX2UFdWil", "ow6pcPecctg2qV0ZfZPclItI1mDAuY8GKfQ4l5vA"); 

	// Specify an Activity to handle all pushes by default.
	PushService.setDefaultPushCallback(this, Notify_main.class);
  }
}