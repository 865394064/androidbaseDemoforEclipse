package com.example.android20170513_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ThreeActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three);
		tv = (TextView) this.findViewById(R.id.tv);
		Intent i = this.getIntent();// 得到上个界面传递过来的intent
		if (i != null) {
			Bundle bundle = i.getExtras();
			if (bundle != null) {
				String name = bundle.getString("name");
				int age = bundle.getInt("age");
				tv.setText(name + "的年龄是" + age);
			}
		}

	}

}
