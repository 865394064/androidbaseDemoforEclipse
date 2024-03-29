package com.example.shuju;

import java.util.List;
import java.util.Map;

import android.content.ContentValues;

public interface DaoInterface {
	// 插入
	public boolean insert(ContentValues cv);

	// 删除方法
	public boolean delete(String whereClause, String[] whereArgs);

	// 查找单行数据返回map
	public Map<String, String> selectsingleline(String[] columns,
			String selection, String[] selectionArgs);

	// 查找单行数据返回对象
	public Object selectsingleline2(String[] columns, String selection,
			String[] selectionArgs);

	// 查找多行数据返回map列表
	public List<Map<String, String>> selectall(String[] columns,
			String selection, String[] selectionArgs);

	// 查找多行数据返回对象列表
	public List<Object> selectall2(String[] columns, String selection,
			String[] selectionArgs);

	// 更新数据
	public boolean update(ContentValues values, String whereClause,
			String[] whereArgs);
}
