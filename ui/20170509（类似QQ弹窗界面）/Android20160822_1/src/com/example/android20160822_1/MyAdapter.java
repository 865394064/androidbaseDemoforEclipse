package com.example.android20160822_1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<MyData> list = new ArrayList<MyData>();

	public MyAdapter(Context context, ArrayList<MyData> list) {
		this.context = context;
		this.list = list;
	}

	// listview显示的item个数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	// list里面对应的第poisiton项对象
	@Override
	public Object getItem(int poisiton) {
		// TODO Auto-generated method stub
		return list.get(poisiton);
	}

	// 获取到poisiton下标
	@Override
	public long getItemId(int poisiton) {
		// TODO Auto-generated method stub
		return poisiton;
	}

	// 获取对应的item视图
	@Override
	public View getView(final int poisiton, View ContextView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (ContextView == null) {
			ContextView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
		}
		MyData data = list.get(poisiton);
		ImageView iv = (ImageView) ContextView.findViewById(R.id.iv);
		TextView tv1 = (TextView) ContextView.findViewById(R.id.tv1);
		TextView tv2 = (TextView) ContextView.findViewById(R.id.tv2);
		Button btn = (Button) ContextView.findViewById(R.id.btn_delete);
//		iv.setBackgroundDrawable(context.getResources().getDrawable(
//				data.getImg()));
		tv1.setText(data.getName());
		tv2.setText(data.getQq());
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				list.remove(poisiton);
				notifyDataSetChanged();
			}
		});
		return ContextView;
	}

}
