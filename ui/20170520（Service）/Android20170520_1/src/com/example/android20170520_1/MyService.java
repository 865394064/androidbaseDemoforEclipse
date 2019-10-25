package com.example.android20170520_1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	// 创建，只有服务创建的时候才执行，如果服务已存在则不执行
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("创建服务+onCreate()");
	}

	// 销毁服务
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("销毁服务+onDestroy()");
	}
	// 业务逻辑处理
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		System.out.println("业务逻辑处理+onStart()");
		
	}
	// 业务逻辑处理
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("业务逻辑处理+onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
