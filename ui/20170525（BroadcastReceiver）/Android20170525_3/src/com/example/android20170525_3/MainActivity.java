package com.example.android20170525_3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
 * 代码动态注册广播接收者
 */
public class MainActivity extends Activity {
	MyBroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registBroadcast();// 注册广播接收者
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			Intent i = new Intent("GUANGBO1");
			sendBroadcast(i);
			break;
		case R.id.btn2:
			Intent i2 = new Intent("GUANGBO2");
			sendBroadcast(i2);
			break;

		default:
			break;
		}
	}

	// 注册广播接收者
	public void registBroadcast() {
		receiver = new MyBroadcastReceiver();
		IntentFilter filter1 = new IntentFilter("GUANGBO1");
		registerReceiver(receiver, filter1);

		IntentFilter filter2 = new IntentFilter("GUANGBO2");
		registerReceiver(receiver, filter2);
	}

	class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context arg0, Intent intent) {
			// TODO Auto-generated method stub
			if ("GUANGBO1".equals(intent.getAction())) {
				Toast.makeText(arg0, "接收到广播一", Toast.LENGTH_SHORT).show();
			} else if ("GUANGBO2".equals(intent.getAction())) {
				Toast.makeText(arg0, "接收到广播二", Toast.LENGTH_SHORT).show();
			}
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);// 取消注册
	}

}
