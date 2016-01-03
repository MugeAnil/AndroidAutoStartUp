package com.example.androidautostartup;

import android.app.Service;
import android.os.IBinder;
import android.widget.Toast;
import android.content.Intent;

public class AutoStartUp extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

		Intent intent = new Intent(this, MainActivity2.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);

	}

}