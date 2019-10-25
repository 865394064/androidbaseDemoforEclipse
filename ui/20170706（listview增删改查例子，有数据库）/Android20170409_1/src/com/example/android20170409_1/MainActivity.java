package com.example.android20170409_1;

import java.util.List;
import com.example.shuju.UserDAO;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listview;
	List<Object> list;
	UserDAO userDao;
	MyAdapter adapter;
	MyBroadcastReciver reciver;
	EditText et_chazhao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerReceiver();// 注册广播
		userDao = new UserDAO(this);
		listview = (ListView) findViewById(R.id.listview);
		et_chazhao = (EditText) findViewById(R.id.et_chazhao);
		inData();// 查找所有数据
		setAdapter();// 设置适配器
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int posstion, long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, UpdateActivity.class);
				User user = (User) list.get(posstion);
				i.putExtra("user", user);
				startActivity(i);
			}
		});
	}

	// 获取所有数据
	public void inData() {
		list = userDao.selectall2(new String[] { "id", "name", "age", "qq" },
				null, null);
	}

	// 设置适配器
	public void setAdapter() {
		if (adapter == null) {
			adapter = new MyAdapter(this, list);
			listview.setAdapter(adapter);
		} else {
			adapter.setList(list);
			adapter.notifyDataSetChanged();
		}
	}

	public void click(View v) {
		switch (v.getId()) {
		// 添加
		case R.id.add:
			startActivity(new Intent(this, AddActivity.class));
			break;
		// 查找
		case R.id.btn_chazhao:
			String str_chazhao = et_chazhao.getText().toString().trim();
			if (TextUtils.isEmpty(str_chazhao)) {
				setAdapter();
			} else {
				List<Object> list1 = userDao.selectall2(new String[] { "id",
						"name", "age", "qq" }, "qq like ?", new String[] { "%"
						+ str_chazhao + "%" });
				adapter.setList(list1);
				adapter.notifyDataSetChanged();

			}
			break;

		default:
			break;
		}
	}

	public void registerReceiver() {
		reciver = new MyBroadcastReciver();
		IntentFilter filter = new IntentFilter("UPDATE");
		registerReceiver(reciver, filter);
	}

	class MyBroadcastReciver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent != null && intent.getAction().equals("UPDATE")) {
				inData();// 查找所有数据
				setAdapter();// 设置适配器
			}
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(reciver);
	}

}
