package com.example.android20170513_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	private String name = "张三";
	private int age = 18;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// Intent直接携带数据
			Intent i1 = new Intent(this, TwoActivity.class);
			i1.putExtra("name", name);// 把数据存放到intent里面
			i1.putExtra("age", age);

			startActivity(i1);
			break;
		case R.id.btn2:// Bundle携带数据
			Intent i2 = new Intent(this, ThreeActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("name", name);
			bundle.putInt("age", age);

			i2.putExtras(bundle);
			startActivity(i2);
			break;
		case R.id.btn3:// bundle携带对象数据
			Intent i3 = new Intent(this, FourActivity.class);
			User user = new User(name, age);
			Bundle bundle3 = new Bundle();
			bundle3.putSerializable("user", user);
			i3.putExtras(bundle3);
			startActivity(i3);
			break;

		default:
			break;
		}
	}
}
