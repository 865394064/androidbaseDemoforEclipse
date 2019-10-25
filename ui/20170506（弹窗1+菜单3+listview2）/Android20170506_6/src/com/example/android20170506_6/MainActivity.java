package com.example.android20170506_6;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

/*
 * baseAdapter
 */
public class MainActivity extends Activity {
	ListView listview;
	List<User> list;
	MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 1.实例化Listview控件；
		listview = (ListView) findViewById(R.id.listview);
		// 2.获取数据
		getData();
		// 3.实例化适配器
		adapter = new MyAdapter(list, this);
		// 4.给listview控件设置适配器
		listview.setAdapter(adapter);
		// 5.设置listview的点击事件
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int posstion, long arg3) {
				// TODO Auto-generated method stub
				User user = list.get(posstion);
				Toast.makeText(MainActivity.this,
						user.getName() + "的qq是" + user.getQq(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	// 获取数据
	public void getData() {
		list = new ArrayList<User>();
		User user = null;
		for (int i = 0; i < 20; i++) {
			user = new User("张三" + i, "215452154" + i);
			list.add(user);
		}
	}
}
