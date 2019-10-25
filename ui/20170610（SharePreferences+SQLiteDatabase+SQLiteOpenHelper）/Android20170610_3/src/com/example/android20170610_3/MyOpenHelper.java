package com.example.android20170610_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
	private static String name = "data.db";
	private static int version = 1;

	public MyOpenHelper(Context context) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	// 只有首次创建数据库的时候才执行
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table if not exists user(id integer primary key,name text,mima text);";
		db.execSQL(sql);
		db.execSQL("insert into user (name,mima) values ('王志丹','123456')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		// 只有当arg1和arg2不一致时才会调用当前方法
	}

}
