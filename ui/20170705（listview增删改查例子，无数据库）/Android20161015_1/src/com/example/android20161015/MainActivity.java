package com.example.android20161015;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listview;
	ArrayList<User> list, list1;
	MyAdapter adapter;
	EditText et_chazhao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_chazhao = (EditText) this.findViewById(R.id.et_chazhao);
		// 第一步:查找到listview控件
		listview = (ListView) this.findViewById(R.id.listview);
		// 第二步:数据
		list = new ArrayList<User>();

		getlist();
		// 第三步:适配器
		setAdapaer();
		listview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int id,
					long arg3) {
				// TODO Auto-generated method stub
				User user = list.get(id);
				Intent i = new Intent(MainActivity.this, UpdateActivity.class);
				i.putExtra("user", user);
				i.putExtra("id", id);
				startActivityForResult(i, 102);
			}
		});
	}

	// 设置初始数据
	public void getlist() {
		User user = new User("张三", "18", "5424812485");
		list.add(user);
		user = new User("张四", "23", "54546885");
		list.add(user);
		user = new User("张无", "24", "333333333");
		list.add(user);
		user = new User("张七", "28", "54545487885");
		list.add(user);
	}

	// 设置适配器的方法
	public void setAdapaer() {
		if (adapter == null) {
			adapter = new MyAdapter(this, list);
			listview.setAdapter(adapter);
		} else {
			adapter.setList(list);
			adapter.notifyDataSetChanged();
		}
	}

	// 点击事件方法
	public void click(View v) {
		switch (v.getId()) {
		// 添加
		case R.id.add:
			startActivityForResult(new Intent(this, AddActivity.class), 101);
			break;
		// 查找
		case R.id.btn_chazhao:
			String chazhao = et_chazhao.getText().toString().trim();
			if (TextUtils.isEmpty(chazhao)) {
				setAdapaer();
			} else {
				chaxun(chazhao);
				adapter.setList(list1);
				adapter.notifyDataSetChanged();
			}
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			if (resultCode == 102) {
				User user = (User) data.getSerializableExtra("user");
				int id = data.getIntExtra("id", 0);
				list.set(id, user);
				setAdapaer();
			} else if (resultCode == 101) {
				User user = (User) data.getSerializableExtra("user");
				list.add(user);
				setAdapaer();
			}
		}
	}

	public void chaxun(String st) {
		if (list1 == null) {
			list1 = new ArrayList<User>();
		} else {
			list1.clear();
		}
		User user = null;
		for (int i = 0; i < list.size(); i++) {
			user = list.get(i);
			if (user.getQq().contains(st)) {
				list1.add(user);
			}
		}
	}

}
