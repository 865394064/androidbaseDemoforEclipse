package com.example.android20170506_6;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private List<User> list;
	private Context context;

	public MyAdapter(List<User> list, Context context) {
		this.list = list;
		this.context = context;
	}

	// 列表中显示的item的个数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	// 获取对应下标的对象数据
	@Override
	public Object getItem(int posstion) {
		// TODO Auto-generated method stub
		return list.get(posstion);
	}

	// 获取对应的下标
	@Override
	public long getItemId(int posstion) {
		// TODO Auto-generated method stub
		return posstion;
	}

	// 返回对应下标的item视图（包括布局和数据结合）
	@Override
	public View getView(final int posstion, View contextView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (contextView == null) {
			// xml布局转换成View
			contextView = View.inflate(context, R.layout.item, null);
		}
		// 实例化控件
		TextView tv_name = (TextView) contextView.findViewById(R.id.tv_name);
		TextView tv_qq = (TextView) contextView.findViewById(R.id.tv_qq);
		TextView tv_delete = (TextView) contextView
				.findViewById(R.id.tv_delete);

		// 获取对应下标的数据
		User user = list.get(posstion);
		// 填充数据
		tv_name.setText(user.getName());
		tv_qq.setText(user.getQq());
		tv_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				list.remove(posstion);// 移除对应下标的数据
				notifyDataSetChanged();// 重新刷新
			}
		});
		return contextView;
	}

}
