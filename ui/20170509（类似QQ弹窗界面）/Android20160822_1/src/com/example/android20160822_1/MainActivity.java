package com.example.android20160822_1;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView lv;
	ArrayList<MyData> list;
	MyAdapter adapter;

	EditText et;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) this.findViewById(R.id.et);
		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createPop();
				pop.showAsDropDown(v);
			}
		});

	}

	PopupWindow pop;

	public void createPop() {
		if (pop == null) {
			View view = LayoutInflater.from(this)
					.inflate(R.layout.dialog, null);
			// 第一步：listview控件
			lv = (ListView) view.findViewById(R.id.listview);
			setListview();
			// 创建PopupWindow对象
			pop = new PopupWindow(view, LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT, false);
			// 需要设置一下此参数，点击外边可消失
			pop.setBackgroundDrawable(new BitmapDrawable());
			// 设置点击窗口外边窗口消失
			pop.setOutsideTouchable(true);
			// 设置此参数获得焦点，否则无法点击
			pop.setFocusable(true);
		}

	}

	public void setListview() {

		// 第二步：数据获取
		list = new ArrayList<MyData>();
		for (int i = 0; i < 20; i++) {
			MyData data = new MyData();
			data.setImg(R.drawable.ic_launcher);
			data.setName("张三" + i);
			data.setQq("5458454512" + i);
			list.add(data);
		}
		// 第三步 ：适配器
		adapter = new MyAdapter(this, list);
		// 第四步：把适配器给lv
		lv.setAdapter(adapter);
		// 第五步：添加lv的item点击事件
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int poisiton, long arg3) {
				// TODO Auto-generated method stub
				MyData data = list.get(poisiton);
				et.setText(data.getName() + "的QQ是" + data.getQq());
				pop.dismiss();
			}
		});
	}
}
