package com.example.android20170422_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv1, tv2, tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) this.findViewById(R.id.tv1);
		tv2 = (TextView) this.findViewById(R.id.tv2);
		tv3 = (TextView) this.findViewById(R.id.tv3);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			// 控件隐藏但是位置还存在
			if (tv1.getVisibility() == View.INVISIBLE) {
				tv1.setVisibility(View.VISIBLE);// 控件显示
			} else {
				tv1.setVisibility(View.INVISIBLE);// 控件隐藏但是位置还存在
			}
			break;
		case R.id.btn2:
			// 控件隐藏且位置不存在
			if (tv2.getVisibility() == View.GONE) {
				tv2.setVisibility(View.VISIBLE);// 控件显示
			} else {
				tv2.setVisibility(View.GONE);// 控件隐藏且位置不存在
			}
			break;
		case R.id.btn3:
			tv1.setVisibility(View.GONE);
			tv2.setVisibility(View.GONE);
			tv3.setVisibility(View.GONE);
			break;

		default:
			break;
		}
	}
}
