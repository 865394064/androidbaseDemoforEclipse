package com.example.android20170617_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.content.ContentValues;

public class DBDAO {
	private MyOpenHelper myhelper;
	private String tablename;
	private SQLiteDatabase db = null;

	public DBDAO(Context context, String tablename) {
		myhelper = new MyOpenHelper(context);
		this.tablename = tablename;
	}

	public boolean insert(ContentValues cv) {
		boolean b = false;
		try {
			db = myhelper.getWritableDatabase();
			int num = (int) db.insert(tablename, null, cv);// 执行插入操作，成功返回行号，失败返回-1
			if (num > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
				db = null;
			}
		}
		return b;
	}

	public boolean update(ContentValues cv, String whereClause,
			String[] whereArgs) {
		boolean b = false;
		try {
			db = myhelper.getWritableDatabase();
			int num = db.update(tablename, cv, whereClause, whereArgs);// 执行插入操作，成功返回行号，失败返回-1
			if (num > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
				db = null;
			}
		}
		return b;
	}

	public boolean delete(String whereClause, String[] whereArgs) {
		boolean b = false;
		try {
			db = myhelper.getWritableDatabase();
			int num = db.delete(tablename, whereClause, whereArgs);// 执行插入操作，成功返回行号，失败返回-1
			if (num > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
				db = null;
			}
		}
		return b;
	}

	public HashMap<String, String> selectSingline(String[] columns,
			String selection, String[] selectionArgs) {
		HashMap<String, String> map = null;
		try {
			db = myhelper.getReadableDatabase();
			Cursor cs = db.query(tablename, columns, selection, selectionArgs,
					null, null, null);

			if (cs != null) {
				map = new HashMap<String, String>();
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
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
				db = null;
			}
		}

		return map;

	}

	public List<HashMap<String, String>> selectAll(String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy) {
		List<HashMap<String, String>> list = null;
		try {
			db = myhelper.getReadableDatabase();
			Cursor cs = db.query(tablename, columns, selection, selectionArgs,
					groupBy, having, orderBy);
			if (cs != null) {
				list = new ArrayList<HashMap<String, String>>();
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
				db = null;
			}
		}

		return list;
	}
}
