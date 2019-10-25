package com.example.android20170513_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 显示意图
			// Intent i1 = new Intent(this, TwoActivity.class);
			Intent i1 = new Intent();
			// i1.setClass(getApplicationContext(), TwoActivity.class);
			i1.setClassName(getApplicationContext(),
					"com.example.android20170513_1.TwoActivity");
			startActivity(i1);
			break;
		case R.id.btn2:// 隐式意图
			// 隐式意图至少需要action和Category；Type和Data如果要同时存在，需要使用setDataAndType  
			Intent i2 = new Intent();
			i2.setAction("www.baidu.com");// 添加动作
			i2.addCategory("android.intent.category.DEFAULT");// 添加约束条件；当前约束条件为默认值，可省略
			// i2.setData(Uri.parse("af1403://com.zy.test:8080/2.txt"));// 设置内容
			// i2.setType("zzz/xxx");
			// 设置类型：注意这个方法会清除setData的内容，所以如果既要设置类型与数据，那么使用setDataAndType    
			i2.setDataAndType(Uri.parse("af1403://com.zy.test:8080/2.txt"),
					"zzz/xxx");

			startActivity(i2);
			break;

		default:
			break;
		}
	}
}
