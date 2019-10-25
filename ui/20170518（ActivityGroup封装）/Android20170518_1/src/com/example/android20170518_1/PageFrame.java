package com.example.android20170518_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PageFrame {
	private ActivityGroup context;
	private FrameLayout frame;
	private LocalActivityManager manager;
	private List<TextView> list_tv;
	private HashMap<Integer, View> map;

	public PageFrame(ActivityGroup context, FrameLayout frame) {
		this.context = context;
		this.frame = frame;
		this.manager = context.getLocalActivityManager();
		list_tv = new ArrayList<TextView>();
		map = new HashMap<Integer, View>();
	}

	public void addpage(Class toclass, String id, int textviewid) {
		Intent i = new Intent(context, toclass);
		final View v = manager.startActivity(id, i).getDecorView();

		frame.addView(v);

		TextView tv = (TextView) context.findViewById(textviewid);
		list_tv.add(tv);
		map.put(textviewid, v);
		tv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setBackgroup(arg0.getId());
			}
		});

	}

	public void setBackgroup(int id) {
		frame.bringChildToFront(map.get(id));
		frame.invalidate();

		TextView tv = null;
		for (int i = 0; i < list_tv.size(); i++) {
			tv = list_tv.get(i);
			if (id == tv.getId()) {
				tv.setBackgroundColor(Color.BLUE);
			} else {
				tv.setBackgroundColor(Color.YELLOW);
			}
		}
	}
}
