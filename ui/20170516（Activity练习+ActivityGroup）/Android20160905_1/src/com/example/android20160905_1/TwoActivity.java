package com.example.android20160905_1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TwoActivity extends Activity {
	ListView listview;
	static ArrayList<Data> list;
	MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		listview = (ListView) this.findViewById(R.id.listview);
		if (list == null) {
			addData();
		}
		setAdapter();
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int poisiton, long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				Bundle bundle = new Bundle();
				Data data = list.get(poisiton);
				bundle.putSerializable("data", data);
				i.putExtras(bundle);
				Toast.makeText(TwoActivity.this, poisiton + "",
						Toast.LENGTH_LONG).show();
				setResult(0, i);
				finish();

			}
		});
	}

	public void addData() {
		list = new ArrayList<Data>();
		Data data = null;
		for (int i = 0; i < 30; i++) {
			data = new Data("张三" + i, "1254642313245" + i);
			list.add(data);
		}
	}

	public void setAdapter() {
		if (adapter == null) {
			adapter = new MyAdapter(list, this);
			listview.setAdapter(adapter);
		} else {
			adapter.setList(list);
			adapter.notifyDataSetChanged();
		}
	}
}
