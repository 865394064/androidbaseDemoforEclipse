package com.example.android20170422_1;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	LinearLayout lin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lin = (LinearLayout) this.findViewById(R.id.lin);
		// addviews();

		// 创建线性布局，添加子元素
		LinearLayout lin2 = new LinearLayout(this);
		lin2.setOrientation(LinearLayout.VERTICAL);// 设置方向为竖直，默认水平方向
		// 设置lin2的布局参数为：宽度占满，高度自适应
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		lin.addView(lin2, params);// 添加lin2为lin的子元素

		// 创建一个TextView，动态添加到lin中
		final TextView tv3 = new TextView(this);// 创建文本
		tv3.setText("文本三");
		tv3.setTextSize(25);
		tv3.setTextColor(Color.GREEN);
		lin2.addView(tv3);// 把tv2添加到lin中,成为第一个子元素

		System.out.println("lin2的子元素有" + lin2.getChildCount() + "个");
	}

	public void addviews() {
		// 创建一个TextView，动态添加到lin中
		final TextView tv2 = new TextView(this);// 创建文本
		tv2.setText("文本二");
		tv2.setTextSize(25);
		tv2.setTextColor(Color.GREEN);
		lin.addView(tv2, 0);// 把tv2添加到lin中,成为第一个子元素

		// 创建一个编辑框
		EditText et = new EditText(this);
		et.setHint("请输入");
		et.setTextSize(20);
		et.setTextColor(Color.RED);
		// 设置et的宽高，然后把et添加到lin中
		lin.addView(et, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// 创建一个按钮
		Button btn = new Button(this);
		btn.setText("删除");
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int count = lin.getChildCount();
				System.out.println("lin当前子元素有" + count + "个");
				if (count > 0) {
					// lin.removeAllViews();// 删除lin下所有子元素
					// lin.removeView(tv2);//删除lin下的tv2子元素
					lin.removeViewAt(0);
				}
			}
		});

		lin.addView(btn);
	}

}
