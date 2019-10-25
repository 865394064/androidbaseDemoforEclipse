package com.example.android20170511_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	// 刚创建还未可视时
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("主界面：刚创建还未可视时+onCreate()");
	}

	// 可视状态
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("主界面：可视状态+onStart()");
	}

	// 获取焦点时
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("主界面：获取焦点时+onResume()");
	}

	// 从不可视到重新可视时执行
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		System.out.println("主界面：从不可视到重新可视时执行+onRestart()");
	}

	// 失去焦点
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println("主界面：失去焦点+onPause()");
	}

	// 不可视的时候
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		System.out.println("主界面：不可视的时候+onStop()");
	}

	// 销毁的时候执行
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("主界面：销毁的时候执行+onDestroy()");
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 跳转到第二界面
			Intent i1 = new Intent(this, TwoActivity.class);// 创建意图
			startActivity(i1);// 启动意图跳转
			break;
		case R.id.btn2:// 跳转到弹窗界面
			Intent i2 = new Intent(this, DialogActivity.class);// 创建意图
			startActivity(i2);// 启动意图跳转
			break;

		default:
			break;
		}
	}
}
