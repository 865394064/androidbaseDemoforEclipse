package com.example.android20170520_2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	// 创建，只执行一次
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("创建，只执行一次+onCreate()");
	}

	// 绑定服务
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		System.out.println("绑定服务+onBind()");
		return new MyBinder();
	}

	// 销毁服务
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("销毁服务+onDestroy()");
	}

	// 解除绑定
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("解除绑定+onUnbind()");
		return super.onUnbind(intent);
	}

	class MyBinder extends Binder {
		public void want(String str) {
			Toast.makeText(MyService.this, "周末想要去" + str, Toast.LENGTH_SHORT)
					.show();
		}
	}
}
