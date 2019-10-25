package com.example.android20170409_1;

import java.util.List;

import com.example.shuju.UserDAO;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private List<Object> list;

	public MyAdapter(Context context, List<Object> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int posstion) {
		// TODO Auto-generated method stub
		return list.get(posstion);
	}

	@Override
	public long getItemId(int posstion) {
		// TODO Auto-generated method stub
		return posstion;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public View getView(int posstion, View ContextView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (ContextView == null) {
			ContextView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
		}
		final User user = (User) list.get(posstion);
		TextView name = (TextView) ContextView.findViewById(R.id.name);
		TextView age = (TextView) ContextView.findViewById(R.id.age);
		TextView qq = (TextView) ContextView.findViewById(R.id.qq);
		TextView delete = (TextView) ContextView.findViewById(R.id.delete);

		final int id = user.getId();
		name.setText(user.getName());
		age.setText(user.getAge());
		qq.setText(user.getQq());
		delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserDAO dao = new UserDAO(context);
				boolean b = dao.delete("id=?", new String[] { id + "" });
				if (b) {
					Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
					context.sendBroadcast(new Intent("UPDATE"));
				} else {
					Toast.makeText(context, "删除失败", Toast.LENGTH_SHORT).show();
				}
			}
		});
		return ContextView;
	}

}
