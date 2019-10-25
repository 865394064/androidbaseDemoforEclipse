package com.example.android20170511_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DialogActivity extends Activity {
	// 刚创建还未可视时
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		System.out.println("弹窗界面：刚创建还未可视时+onCreate()");
	}

	// 可视状态
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("弹窗界面：可视状态+onStart()");
	}

	// 获取焦点时
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("弹窗界面：获取焦点时+onResume()");
	}

	// 从不可视到重新可视时执行
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		System.out.println("弹窗界面：从不可视到重新可视时执行+onRestart()");
	}

	// 失去焦点
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println("弹窗界面：失去焦点+onPause()");
	}

	// 不可视的时候
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		System.out.println("弹窗界面：不可视的时候+onStop()");
	}

	// 销毁的时候执行
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("弹窗界面：销毁的时候执行+onDestroy()");
	}
}
