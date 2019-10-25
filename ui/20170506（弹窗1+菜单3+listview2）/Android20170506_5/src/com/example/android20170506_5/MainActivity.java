package com.example.android20170506_5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/*ArrayAdapter
 * 
 */
public class MainActivity extends Activity {
	ListView listview;
	String items[] = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 第一步：实例化listview
		listview = (ListView) findViewById(R.id.listview);
		// 第二步：数据
		items = new String[] { "aaa", "bbb", "ccc", "ddd", "fff", "ggg", "aaa",
				"bbb", "ccc", "ddd", "fff", "ggg" };
		// 第三步：适配器
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		// 第四步：给listview控件设置适配器
		listview.setAdapter(adapter);
		// 第五部：设置listview点击事件
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int posstion, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,
						"第" + posstion + "个，内容是==" + items[posstion],
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
