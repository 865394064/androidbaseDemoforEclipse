package com.example.android20170506_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

/*
 * 代码添加选项菜单
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
		// menu直接添加子菜单项
		// 添加一级菜单
		menu.add(Menu.NONE, 1, 101, "一级菜单一");// 1是id,101是orderInCategory
		menu.add(Menu.NONE, 2, 102, "一级菜单二").setIcon(R.drawable.ic_launcher);

		// 添加二级菜单
		SubMenu subMenu = menu.addSubMenu(Menu.NONE, 3, 103, "一级菜单展开");
		subMenu.add(Menu.NONE, 21, 1011, "二级菜单一");
		subMenu.add(Menu.NONE, 22, 1012, "二级菜单二");
		return true;
	}

	// 处理选项菜单点击事件
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// 一级菜单和二级菜单的点击触发事件是一样
		int id = item.getItemId();
		switch (id) {
		case 1:

			break;
		case 2:

			break;
		case 21:

			break;

		default:
			break;
		}
		// 吐司点击的子项菜单的文本内容
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		return super.onOptionsItemSelected(item);
	}
}
