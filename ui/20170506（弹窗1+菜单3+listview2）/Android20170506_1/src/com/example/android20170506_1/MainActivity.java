package com.example.android20170506_1;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);//设置窗口无标题
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createPopWindow();
			}
		});
	}

	PopupWindow pop;

	public void createPopWindow() {
		if (pop == null) {
			View view = View.inflate(this, R.layout.dialog, null);
			Button btn_yes = (Button) view.findViewById(R.id.btn_yes);
			Button btn_no = (Button) view.findViewById(R.id.btn_no);
			pop = new PopupWindow(view, LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			// 需要设置一下此参数，点击外边可消失
			pop.setBackgroundDrawable(new BitmapDrawable());
			// 设置点击窗口外边窗口消失
			pop.setOutsideTouchable(true);
			// 设置此参数获得焦点，否则无法点击
			pop.setFocusable(true);

			btn_yes.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					pop.dismiss();// 隐藏弹窗
					finish();// 关闭界面
				}
			});
			btn_no.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					pop.dismiss();// 隐藏弹窗
				}
			});
		}
		pop.showAsDropDown(btn);// 注册：当点击btn时显示弹窗
	}
}
