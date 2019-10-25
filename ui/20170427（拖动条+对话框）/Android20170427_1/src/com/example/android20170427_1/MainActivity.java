package com.example.android20170427_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv1, tv2;
	SeekBar seekbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seekbar = (SeekBar) this.findViewById(R.id.seekbar);
		tv1 = (TextView) this.findViewById(R.id.tv1);
		tv2 = (TextView) this.findViewById(R.id.tv2);
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			// 停止拖到（松开）的时候
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				tv1.setText("当前状态：松开");
			}

			// 开始拖到（按下）的时候
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				tv1.setText("当前状态：按下");
			}

			// 当前进度值发生改变的时候
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				tv2.setText("当前的进度值=" + arg1);
			}
		});
	}

}
