package com.example.android20170425_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	ProgressBar progress;
	Button btn;
	Thread t = null;
	boolean b = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progress = (ProgressBar) this.findViewById(R.id.progress);
		progress.setIndeterminate(false);// 取消滚动效果
		progress.setMax(100);// 设置进度条最大值为100

		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 如果t为空或者t为死亡状态
				if (t == null || !t.isAlive()) {// t.isAlive():t线程存活
					b = true;
					CreateThread();
					t.start();// 启动子线程
				} else {
					// t为存活状态
					b = false;
				}

			}
		});

	}

	public void CreateThread() {
		t = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					while (progress.getProgress() < progress.getMax() && b) {
						// 进度条当前进度值小于最大进度值时执行
						progress.setProgress(progress.getProgress() + 1);
						Thread.sleep(100);
					}
					// 如果当前进度值等于最大值，重新设置当前进度值为0
					if (progress.getProgress() == progress.getMax()) {
						progress.setProgress(0);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
	}

}
