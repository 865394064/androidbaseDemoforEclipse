package com.example.android20170606_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent i1 = new Intent(this, MyIntentService.class);
		i1.putExtra("num", 1);
		startService(i1);// 启动服务

		Intent i2 = new Intent(this, MyIntentService.class);
		i2.putExtra("num", 2);
		startService(i2);// 启动服务
	}

}
