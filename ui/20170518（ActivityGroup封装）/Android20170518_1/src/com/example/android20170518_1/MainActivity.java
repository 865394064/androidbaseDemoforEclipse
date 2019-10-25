package com.example.android20170518_1;

import android.app.ActivityGroup;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends ActivityGroup {
	private FrameLayout frame;
	PageFrame pageFrame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		frame = (FrameLayout) findViewById(R.id.frame);
		pageFrame = new PageFrame(this, frame);

		pageFrame.addpage(OneActivity.class, "第一页", R.id.tv1);
		pageFrame.addpage(TwoActivity.class, "第二页", R.id.tv2);
		pageFrame.addpage(ThreeActivity.class, "第三页", R.id.tv3);

		pageFrame.setBackgroup(R.id.tv1);

	}

}
