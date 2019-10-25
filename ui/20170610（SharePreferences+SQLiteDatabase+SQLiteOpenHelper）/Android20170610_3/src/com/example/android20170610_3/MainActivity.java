package com.example.android20170610_3;

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
	SQLiteDatabase db;// 声明数据库对象
	MyOpenHelper myhelper;
	ContentValues cv;// 存储工具类
	int n = 0;
	int num;// 操作返回的数
	Cursor cs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 如果数据库对象不存在，则创建并打开；如果数据库对象已存在，则打开
		myhelper = new MyOpenHelper(this);

	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 创建表
			db = myhelper.getWritableDatabase();
			String sql = "create table if not exists user(id integer primary key,name text,mima text);";
			db.execSQL(sql);
			// db.execSQL("insert into user (name,mima) values ('王志丹','123456')");
			Toast.makeText(this, "建表成功", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn2:// 插入数据
			db = myhelper.getWritableDatabase();
			cv = new ContentValues();// 初始化存储工具类
			cv.put("name", "张三" + n);
			cv.put("mima", "1234" + n);
			num = (int) db.insert("user", null, cv);// 执行插入操作，成功返回行号，失败返回-1
			System.out.println("插入数据返回num=" + num);
			if (num > 0) {
				Toast.makeText(this, "插入数据成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "插入数据失败", Toast.LENGTH_SHORT).show();
			}
			n++;
			break;
		case R.id.btn3:// 修改数据
			db = myhelper.getWritableDatabase();
			cv = new ContentValues();// 初始化存储工具类
			cv.put("name", "张三疯");
			cv.put("mima", "111111");
			// 返回修改成功的行数，修改失败返回0
			num = db.update("user", cv, "name=?", new String[] { "张三2" });
			System.out.println("修改数据返回num=" + num);
			if (num > 0) {
				Toast.makeText(this, "修改数据成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "修改数据失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn4:// 删除数据
			db = myhelper.getWritableDatabase();
			// 返回删除成功的行数，失败返回0
			num = db.delete("user", "name=?", new String[] { "张三0" });
			System.out.println("删除数据返回num=" + num);
			if (num > 0) {
				Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "删除数据失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn5:// 查询单个数据
			db = myhelper.getReadableDatabase();
			// 查询操作返回Cursor游标对象
			cs = db.query("user", new String[] { "id", "name", "mima" },
					"id=?", new String[] { 3 + "" }, null, null, null);
			HashMap<String, String> map = new HashMap<String, String>();
			if (cs != null) {
				// 如果查询到有数据
				if (cs.moveToNext()) {
					// int id = cs.getInt(cs.getColumnIndex("id"));
					// String name = cs.getString(cs.getColumnIndex("name"));
					// String mima = cs.getString(cs.getColumnIndex("mima"));

					int count = cs.getColumnCount();// 得到要查询的字段个数
					for (int i = 0; i < count; i++) {
						String key = cs.getColumnName(i);// 下标对应的字段名称
						String zhi = cs.getString(i);// 下标对应的字段的值
						map.put(key, zhi);
					}
					System.out.println("查询到的数据：" + map.toString());
				}
			}
			break;
		case R.id.btn6:// 查询所有数据
			db = myhelper.getReadableDatabase();
			cs = db.query("user", new String[] { "id", "name", "mima" }, null,
					null, null, null, "id desc");
			List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (cs != null) {
				// 如果有多条数据，则一条一条读取
				int count = cs.getColumnCount();// 得到要查询的字段个数
				while (cs.moveToNext()) {
					HashMap<String, String> map0 = new HashMap<String, String>();
					for (int i = 0; i < count; i++) {
						String key = cs.getColumnName(i);// 下标对应的字段名称
						String zhi = cs.getString(i);// 下标对应的字段的值
						map0.put(key, zhi);
					}
					list.add(map0);
				}
			}
			System.out.println("查询到所有数据=" + list.toString());
			break;
		default:
			break;
		}
	}
}
