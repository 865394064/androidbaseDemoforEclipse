package com.example.android20170520_1;

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
		Intent i = new Intent(this, MyService.class);
		switch (v.getId()) {
		case R.id.btn1:// 启动服务

			startService(i);
			break;
		case R.id.btn2:// 停止服务
			stopService(i);
			break;

		default:
			break;
		}
	}
}
