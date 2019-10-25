package com.example.android20170606_2;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {
	// 无参数的构造方法：必须的
	public MyIntentService() {
		super("");
		// TODO Auto-generated constructor stub
	}

	// 按照先后顺序以队列的方式对intent进行处理，每处理一个intent事件开启一个worker thread(线程)
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		int num = intent.getIntExtra("num", 0);
		switch (num) {
		case 1:
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("接收到数据1");
			break;
		case 2:
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("接收到数据2");
			break;
		default:
			break;
		}
	}

	// 当onHandleIntent里面的事件执行完毕后执行
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("onDestroy()");

	}

}
