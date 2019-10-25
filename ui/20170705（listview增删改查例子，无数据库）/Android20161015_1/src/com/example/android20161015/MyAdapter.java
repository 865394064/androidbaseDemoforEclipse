package com.example.android20161015;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Context context;
	ArrayList<User> list = new ArrayList<User>();

	public MyAdapter(Context context, ArrayList<User> list) {
		this.context = context;
		this.list = list;
	}

	public ArrayList<User> getList() {
		return list;
	}

	public void setList(ArrayList<User> list) {
		this.list = list;
	}

	// 展示的item的数量
	public int getCount() {
		// TODO Auto-generated method stub
		if (list.size() > 0) {
			return list.size();
		} else {
			return 1;
		}

	}

	// 通过position获取到list里面对应的User对象
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	// 获取对应的position
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	// 返回item视图
	public View getView(final int position, View convertView,
			ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		if (list.size() > 0) {

			convertView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
			User user = list.get(position);
			TextView name = (TextView) convertView.findViewById(R.id.name);
			TextView age = (TextView) convertView.findViewById(R.id.age);
			TextView qq = (TextView) convertView.findViewById(R.id.qq);
			TextView delete = (TextView) convertView.findViewById(R.id.delete);

			name.setText(user.getName());
			age.setText(user.getAge());
			qq.setText(user.getQq());
			delete.setOnClickListener(new OnClickListener() {

				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					list.remove(position);
					notifyDataSetChanged();
				}
			});
		} else {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.nullview, null);
		}

		return convertView;
	}

}
