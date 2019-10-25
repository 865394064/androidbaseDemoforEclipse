package com.example.android20170422_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btn1, btn2;
	View view1, view2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		view1 = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
		btn1 = (Button) view1.findViewById(R.id.btn1);
		setContentView(view1);// 设置根View
		// 把two布局转换成View
		view2 = LayoutInflater.from(this).inflate(R.layout.two, null);
		btn2 = (Button) view2.findViewById(R.id.btn2);
		btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setContentView(view2);//设置根View
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setContentView(view1);// 设置根View
			}
		});
	}

}
