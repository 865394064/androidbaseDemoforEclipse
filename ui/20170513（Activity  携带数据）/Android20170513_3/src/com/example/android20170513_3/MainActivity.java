package com.example.android20170513_3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
		case R.id.btn1:// 拨打电话
			Uri uri = Uri.parse("tel:15980665805");
			// Intent intent = new Intent(Intent.ACTION_DIAL, uri);// 跳转到拨号界面
			Intent intent = new Intent(Intent.ACTION_CALL, uri);// 直接拨打电话
			startActivity(intent);
			break;
		case R.id.btn2:// 音乐选择
			// 它使用了Intent.ACTION_GET_CONTENT 和 MIME 类型来查找支持 audio/* 的所有 Data
			// Picker，允许用户选择其中之一
			Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
			intent2.setType("audio/*");
			// Intent.createChooser：应用选择器，这个方法创建一个 ACTION_CHOOSER Intent
			startActivity(Intent.createChooser(intent2, "选择音乐"));
			break;
		case R.id.btn3:// 设置壁纸
			Intent intent3 = new Intent(Intent.ACTION_SET_WALLPAPER);
			startActivity(Intent.createChooser(intent3, "设置壁纸"));
			break;

		default:
			break;
		}
	}
}
