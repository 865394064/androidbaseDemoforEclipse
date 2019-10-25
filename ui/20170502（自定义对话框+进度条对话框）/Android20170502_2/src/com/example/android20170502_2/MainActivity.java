package com.example.android20170502_2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			createYuanProgress();// 创建圆形进度条
			break;
		case R.id.btn2:
			createChangProgress();// 创建长条进度条
			break;
		default:
			break;
		}
	}

	ProgressDialog yuanDialog;

	public void createYuanProgress() {
		if (yuanDialog == null) {
			yuanDialog = new ProgressDialog(this);
			yuanDialog.setMessage("请求中。。。");// 设置提示信息
			yuanDialog.setCancelable(false);// 点击返回按钮的时候不隐藏
		}
		yuanDialog.show();
	}

	ProgressDialog changDialog;

	public void createChangProgress() {
		if (changDialog == null) {
			changDialog = new ProgressDialog(this);
			// 设置长条样式
			changDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			changDialog.setIndeterminate(true);// 设置滚动花纹，默认是没有的
		}
		changDialog.show();
		changDialog.setProgress(10);// 必须要进度条显示以后才有效果
	}
}
