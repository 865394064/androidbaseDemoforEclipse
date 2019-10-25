package com.example.shuju;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlHelper extends SQLiteOpenHelper {
	private static String SQL_NAME = "data.db";
	private static int version = 1;

	// 构造方法
	public MySqlHelper(Context context) {
		super(context, SQL_NAME, null, version);
		// TODO Auto-generated constructor stub
	}

	// 只有创建数据库的时候才会执行，只有执行一次
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table user (id integer PRIMARY KEY,name text,age text,qq text)");
		db.execSQL("insert into user(name,age,qq) values ('张一','18','45454545')");
		db.execSQL("insert into user(name,age,qq) values ('张二','18','23234535')");
		db.execSQL("insert into user(name,age,qq) values ('张三','20','42112212')");
		db.execSQL("insert into user(name,age,qq) values ('李四','19','4502011221')");
		db.execSQL("insert into user(name,age,qq) values ('王五','38','7565454')");
		db.execSQL("insert into user(name,age,qq) values ('赵六','8','2132321')");
		db.execSQL("insert into user(name,age,qq) values ('钱七','10','45454454')");
		db.execSQL("insert into user(name,age,qq) values ('千八','28','54544455')");
		db.execSQL("insert into user(name,age,qq) values ('九九','25','78787454')");
		db.execSQL("insert into user(name,age,qq) values ('牛牛','13','4545647787')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
