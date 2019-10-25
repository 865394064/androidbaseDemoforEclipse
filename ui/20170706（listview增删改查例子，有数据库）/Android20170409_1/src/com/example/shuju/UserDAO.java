package com.example.shuju;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.android20170409_1.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/*/
 * user表的操作类
 */
public class UserDAO implements DaoInterface {
	private MySqlHelper mySqlHelper;
	private String tablename = "user";
	private SQLiteDatabase db;

	public UserDAO(Context context) {
		mySqlHelper = new MySqlHelper(context);
	}

	public boolean insert(ContentValues cv) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			db = mySqlHelper.getWritableDatabase();
			long i = db.insert(tablename, null, cv);
			if (i > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}

		return b;
	}

	public boolean delete(String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			db = mySqlHelper.getWritableDatabase();
			long i = db.delete(tablename, whereClause, whereArgs);
			if (i > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}

		return b;
	}

	public Map<String, String> selectsingleline(String[] columns,
			String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		try {
			db = mySqlHelper.getReadableDatabase();
			Cursor cs = db.query(tablename, columns, selection, selectionArgs,
					null, null, null);
			// 如何下一个还有值的话
			if (cs.moveToFirst()) {
				// 获取到查询的个数
				int count = cs.getColumnCount();
				for (int i = 0; i < count; i++) {
					String name = cs.getColumnName(i);
					String zhi = cs.getString(i);
					map.put(name, zhi);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}
		return map;
	}

	public List<Map<String, String>> selectall(String[] columns,
			String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		Map<String, String> map = null;
		try {
			db = mySqlHelper.getReadableDatabase();
			Cursor cs = db.query(tablename, columns, selection, selectionArgs,
					null, null, null);
			// 如何下一个还有值的话
			while (cs.moveToNext()) {
				// 获取到查询的个数
				map = new HashMap<String, String>();
				int count = cs.getColumnCount();
				for (int i = 0; i < count; i++) {
					String name = cs.getColumnName(i);
					String zhi = cs.getString(i);
					map.put(name, zhi);
				}
				list.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}
		return list;
	}

	public boolean update(ContentValues values, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			db = mySqlHelper.getWritableDatabase();
			long i = db.update(tablename, values, whereClause, whereArgs);
			if (i > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}

		return b;
	}

	@Override
	public Object selectsingleline2(String[] columns, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			db = mySqlHelper.getReadableDatabase();
			Cursor cs = db.query(tablename, columns, selection, selectionArgs,
					null, null, null);
			// 如何下一个还有值的话
			if (cs.moveToFirst()) {
				// 获取到查询的个数
				int id = cs.getInt(cs.getColumnIndex("id"));
				String name = cs.getString(cs.getColumnIndex("name"));
				String age = cs.getString(cs.getColumnIndex("age"));
				String qq = cs.getString(cs.getColumnIndex("qq"));
				user = new User(id, name, age, qq);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}
		return user;
	}

	@Override
	public List<Object> selectall2(String[] columns, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();

		try {
			db = mySqlHelper.getReadableDatabase();
			Cursor cs = db.query(tablename, columns, selection, selectionArgs,
					null, null, null);
			User user;
			// 如何下一个还有值的话
			while (cs.moveToNext()) {
				// 获取到查询的个数
				int id = cs.getInt(cs.getColumnIndex("id"));
				String name = cs.getString(cs.getColumnIndex("name"));
				String age = cs.getString(cs.getColumnIndex("age"));
				String qq = cs.getString(cs.getColumnIndex("qq"));
				user = new User(id, name, age, qq);
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.close();
			}

		}
		return list;
	}

}
