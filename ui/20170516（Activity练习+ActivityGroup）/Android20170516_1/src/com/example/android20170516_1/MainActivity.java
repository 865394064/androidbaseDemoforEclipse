package com.example.android20170516_1;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends ActivityGroup {
	Intent i1, i2, i3;
	LocalActivityManager manager;
	FrameLayout frame;
	View v1, v2, v3;
	List<TextView> list_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list_tv = new ArrayList<TextView>();
		list_tv.add((TextView) findViewById(R.id.tv1));
		list_tv.add((TextView) findViewById(R.id.tv2));
		list_tv.add((TextView) findViewById(R.id.tv3));

		manager = this.getLocalActivityManager();
		frame = (FrameLayout) this.findViewById(R.id.frame);

		i1 = new Intent(this, OneActivity.class);
		i2 = new Intent(this, TwoActivity.class);
		i3 = new Intent(this, ThreeActivity.class);

		v1 = manager.startActivity("第一页", i1).getDecorView();// 把Activity转换成视图
		v2 = manager.startActivity("第二页", i2).getDecorView();// 把Activity转换成视图
		v3 = manager.startActivity("第三页", i3).getDecorView();// 把Activity转换成视图

		frame.addView(v2);
		frame.addView(v3);
		frame.addView(v1);

		setBackgroup(R.id.tv1);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.tv1:
			frame.bringChildToFront(v1);// 把v1调到前台
			frame.invalidate();// 刷新
			break;
		case R.id.tv2:
			frame.bringChildToFront(v2);// 把v1调到前台
			frame.invalidate();// 刷新
			break;
		case R.id.tv3:
			frame.bringChildToFront(v3);// 把v1调到前台
			frame.invalidate();// 刷新
			break;

		default:
			break;
		}
		setBackgroup(v.getId());
	}

	public void setBackgroup(int id) {
		TextView tv = null;
		for (int i = 0; i < list_tv.size(); i++) {
			tv = list_tv.get(i);
			if (id == tv.getId()) {
				tv.setBackgroundColor(Color.BLUE);
			} else {
				tv.setBackgroundColor(Color.YELLOW);
			}
		}
	}
}
