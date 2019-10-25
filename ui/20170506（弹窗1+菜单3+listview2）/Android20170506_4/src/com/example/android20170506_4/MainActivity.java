package com.example.android20170506_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
 * 代码设置上下文菜单
 */
public class MainActivity extends Activity {
	TextView tv;
	View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view=View.inflate(this, R.layout.activity_main, null);
		setContentView(view);
		registerForContextMenu(view);
		
//		setContentView(R.layout.activity_main);
//		tv = (TextView) this.findViewById(R.id.tv);
//		registerForContextMenu(tv);// 注册上下文菜单：当长按tv时显示上下文菜单

	}

	// 添加上下文菜单子项
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		// 添加一级菜单
		menu.add(Menu.NONE, 1, 101, "一级菜单一");// 1是id,101是orderInCategory
		menu.add(Menu.NONE, 2, 102, "一级菜单二").setIcon(R.drawable.ic_launcher);

		// 添加二级菜单
		SubMenu subMenu = menu.addSubMenu(Menu.NONE, 3, 103, "一级菜单展开");
		subMenu.add(Menu.NONE, 21, 1011, "二级菜单一");
		subMenu.add(Menu.NONE, 22, 1012, "二级菜单二");
	}

	// 设置上下文菜单子项点击事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
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
		return super.onContextItemSelected(item);
	}

}
