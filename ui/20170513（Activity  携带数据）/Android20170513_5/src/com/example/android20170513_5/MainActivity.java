package com.example.android20170513_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btn;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn1);
		tv = (TextView) findViewById(R.id.tv);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 第一步：startActivityForResult跳转
				Intent i = new Intent(MainActivity.this, TwoActivity.class);
				startActivityForResult(i, 0);//0为requestCode参数
			}
		});
	}

	// 第三步：接收数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			if (1 == resultCode) {
				String str = data.getStringExtra("str");
				tv.setText("得到返回的数据==" + str);
			}
		}
	}

}
