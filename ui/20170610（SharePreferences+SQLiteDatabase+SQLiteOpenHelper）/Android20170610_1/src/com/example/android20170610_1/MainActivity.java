package com.example.android20170610_1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 存储
			writeData();
			break;
		case R.id.btn2:// 读取
			readData();
			break;

		default:
			break;
		}
	}

	// 读取数据
	public void readData() {
		SharedPreferences sp = this.getSharedPreferences("data", MODE_PRIVATE);
		String qq = sp.getString("qq", "0001");
		tv.setText("读取到账号=" + qq);
	}

	// 存储数据
	public void writeData() {
		SharedPreferences sp = this.getSharedPreferences("data", MODE_PRIVATE);
		String qq = "5566666554";
		Editor edit = sp.edit();// 获取编辑器
		edit.putString("qq", qq);// 存储数据
		edit.commit();// 提交存储数据
	}
}
