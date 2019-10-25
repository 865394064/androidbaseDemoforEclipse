package com.example.android20170513_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FourActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		tv = (TextView) this.findViewById(R.id.tv);
		Intent i = this.getIntent();// 得到上个界面传递过来的intent
		if (i != null) {
			Bundle bundle = i.getExtras();
			if (bundle != null) {
				User user = (User) bundle.getSerializable("user");
				tv.setText(user.getName() + "的年龄是" + user.getAge());
			}
		}
	}

}
