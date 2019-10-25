package com.example.android20170617_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	ContentValues cv;// 存储工具类
	int n = 0;
	Cursor cs;
	DBDAO dao;
	boolean b = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dao = new DBDAO(this, "user");

	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn2:// 插入数据
			cv = new ContentValues();// 初始化存储工具类
			cv.put("name", "张三" + n);
			cv.put("mima", "1234" + n);
			b = dao.insert(cv);
			if (b) {
				Toast.makeText(this, "插入数据成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "插入数据失败", Toast.LENGTH_SHORT).show();
			}
			n++;
			break;
		case R.id.btn3:// 修改数据
			cv = new ContentValues();// 初始化存储工具类
			cv.put("name", "张三疯");
			cv.put("mima", "111111");
			// true表示修改成功
			b = dao.update(cv, "name=?", new String[] { "张三2" });
			if (b) {
				Toast.makeText(this, "修改数据成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "修改数据失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn4:// 删除数据
			// true表示删除成功
			b = dao.delete("name=?", new String[] { "张三0" });
			if (b) {
				Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "删除数据失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn5:// 查询单个数据
			HashMap<String, String> map = dao.selectSingline(new String[] {
					"id", "name", "mima" }, "id=?", new String[] { 3 + "" });
			if (map != null) {
				System.out.println("查询到单行数据=" + map.toString());
			}
			break;
		case R.id.btn6:// 查询所有数据
			List<HashMap<String, String>> list = null;
			list = dao.selectAll(new String[] { "id", "name", "mima" }, null,
					null, null, null, "id desc");
			if (list != null) {
				System.out.println("查询到所有数据=" + list.toString());
			}

			break;
		default:
			break;
		}
	}
}
