package com.example.android20170506_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/*
 * 通过xml实现选项菜单
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// 创建选项菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);// 把xml菜单布局转换成实例添加到menu里面
		return true;
	}

	// 处理选项菜单点击事件
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// 一级菜单和二级菜单的点击触发事件是一样
		int id = item.getItemId();
		switch (id) {
		case R.id.item1:

			break;
		case R.id.item2:

			break;
		case R.id.item21:

			break;

		default:
			break;
		}
		// 吐司点击的子项菜单的文本内容
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		return super.onOptionsItemSelected(item);
	}
}
