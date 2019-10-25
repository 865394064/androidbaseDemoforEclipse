package com.example.android20170513_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TwoActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		tv = (TextView) this.findViewById(R.id.tv);
		Intent i = this.getIntent();// 得到上个界面传递过来的intent
		if (i != null) {
			String name = i.getStringExtra("name");
			int age = i.getIntExtra("age", 0);
			tv.setText(name + "的年龄是" + age);
		}
	}

}
