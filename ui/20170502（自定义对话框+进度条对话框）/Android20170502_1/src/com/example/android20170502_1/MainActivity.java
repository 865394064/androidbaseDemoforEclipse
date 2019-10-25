package com.example.android20170502_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 * 自定义对话框
 */
public class MainActivity extends Activity {
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createDialog();
			}
		});
	}

	AlertDialog dialog;

	public void createDialog() {
		if (dialog == null) {
			View view = View.inflate(this, R.layout.dialog, null);
			TextView btn_yes = (TextView) view.findViewById(R.id.btn_yes);
			TextView btn_no = (TextView) view.findViewById(R.id.btn_no);

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			dialog = builder.setView(view).create();// 如果有调用setView()方法，必须调用create()方法
			btn_yes.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.dismiss();// 隐藏对话框
					finish();// 关闭界面
				}
			});
			btn_no.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.dismiss();// 隐藏对话框
				}
			});
			dialog.setCancelable(false);// 点击返回按钮时不能隐藏对话框
		}
		dialog.show();
	}
}
