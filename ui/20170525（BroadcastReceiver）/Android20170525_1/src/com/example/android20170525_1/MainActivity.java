package com.example.android20170525_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			Intent i = new Intent("GUANGBO2017052501");
			sendBroadcast(i);//发送广播
			break;
		case R.id.btn2:
			Intent i2 = new Intent("GUANGBO2017052502");
			sendBroadcast(i2);
			break;

		default:
			break;
		}
	}
}
