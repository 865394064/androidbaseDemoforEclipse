package com.example.android20170425_1;

import java.util.HashMap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity<view> extends Activity {
	LinearLayout lin2;
	FrameLayout frame;

	int i = 1;
	HashMap<Button, View> map;
	int[] colors = new int[] { Color.GRAY, Color.BLACK, Color.YELLOW,
			Color.GREEN, Color.RED };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lin2 = (LinearLayout) findViewById(R.id.lin2);
		frame = (FrameLayout) findViewById(R.id.frame);
		map = new HashMap<Button, View>();

	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			// 创建按钮并且添加到lin里面
			Button btn = new Button(MainActivity.this);
			btn.setText("第" + i + "个");
			lin2.addView(btn);
			// 创建view添加到frame里面
			final View a = View.inflate(MainActivity.this, R.layout.fram, null);
			TextView tv = (TextView) a.findViewById(R.id.tv);
			tv.setText("第" + i + "页");
			tv.setTextColor(colors[i % 5]);
			frame.addView(a);
			// 按钮添加监听事件
			btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					// 把对应的View调到前台并刷新
					frame.bringChildToFront(a);
					frame.invalidate();
				}
			});
			// 把按钮和View绑定到一块
			map.put(btn, a);
			i++;
			break;

		case R.id.btn2:
			if (frame.getChildCount() > 0) {

				Button button = (Button) lin2.getChildAt(0);// 得到lin2里面第一个子控件
				View view = map.get(button);// 得到button对应的View
				lin2.removeView(button);// 移除lin2里面的子控件(button)
				frame.removeView(view);

				// lin2.getChildAt(0).performClick();//点击了lin2.getChildAt(0)对应的按钮
				// frame.removeViewAt(lin2.getChildCount() - 1);
				// lin2.removeViewAt(0);
			}
			break;

		case R.id.btn3:
			lin2.removeAllViews();
			frame.removeAllViews();
			i = 1;
			break;

		default:
			break;
		}
	}

}
