package com.example.android20160905_1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	ArrayList<Data> list = new ArrayList<Data>();
	Context context;

	public MyAdapter(ArrayList<Data> list, Context context) {
		this.list = list;
		this.context = context;
	}

	public ArrayList<Data> getList() {
		return list;
	}

	public void setList(ArrayList<Data> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int poisiton) {
		// TODO Auto-generated method stub
		return list.get(poisiton);
	}

	@Override
	public long getItemId(int poisiton) {
		// TODO Auto-generated method stub
		return poisiton;
	}

	@Override
	public View getView(final int poisiton, View contextView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (contextView == null) {
			contextView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
		}
		TextView name = (TextView) contextView.findViewById(R.id.tv1);
		TextView qq = (TextView) contextView.findViewById(R.id.tv2);
		TextView delete = (TextView) contextView.findViewById(R.id.tv_delete);
		Data data = list.get(poisiton);
		if (data != null) {
			name.setText(data.getName());
			qq.setText(data.getQq());
			delete.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					list.remove(poisiton);
					notifyDataSetChanged();
				}
			});
		}

		return contextView;
	}

}
