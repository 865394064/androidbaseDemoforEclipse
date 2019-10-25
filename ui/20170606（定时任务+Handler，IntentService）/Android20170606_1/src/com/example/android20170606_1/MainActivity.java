package com.example.android20170606_1;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv;
	Timer timer;// 定时工具：在给定时间以后执行某个任务
	TimerTask task;// 任务类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 启动任务
			timer = new Timer();// 实例化定时工具
			createTimerTask();// 实例化任务类
			// timer.schedule(task, 3000);// 3秒以后执行任务
			timer.schedule(task, 3000, 2000);// 3秒以后第一次执行任务，然后每隔2秒重复执行任务
			tv.setText("任务执行中");
			break;
		case R.id.btn2:// 结束任务
			if (timer != null) {
				timer.cancel();// 取消任务
				tv.setText("任务已取消");
			}

			break;
		default:
			break;
		}
	}

	// 任务类
	public void createTimerTask() {
		task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message message = new Message();// 新建一个消息
				message.what = 0;// 设置消息内容
				handler.sendMessage(message);// 发送消息给Handler
				// handler.sendEmptyMessage(0);//如果message里面不需要包含数据时
			}
		};
	}

	// Handler:消息处理机制（在主线程中执行）:按照接收到的消息的先后顺序来处理事件
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				Toast.makeText(MainActivity.this, "接收到消息了", Toast.LENGTH_SHORT)
						.show();
				break;
			case 1:

				break;

			default:
				break;
			}
		}

	};
}
