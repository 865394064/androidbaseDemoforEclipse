package com.example.android20170422_5;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	FrameLayout frame;
	View v1, v2, v3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		v1 = LayoutInflater.from(this).inflate(R.layout.one, null);// 把one.xml文件转换成视图对象
		v2 = View.inflate(this, R.layout.two, null);// 把two.xml文件转换成视图对象
		v3 = View.inflate(this, R.layout.three, null);
		frame = (FrameLayout) this.findViewById(R.id.frame);
		// frame添加子View
		frame.addView(v1);
		frame.addView(v2);
		frame.addView(v3);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			frame.bringChildToFront(v1);// 把v1调到前面
			frame.invalidate();// 刷新界面
			break;
		case R.id.btn2:
			frame.bringChildToFront(v2);// 把v2调到前面
			frame.invalidate();// 刷新界面
			break;
		case R.id.btn3:
			frame.bringChildToFront(v3);// 把v3调到前面
			frame.invalidate();// 刷新界面
			break;

		default:
			break;
		}
	}
}
