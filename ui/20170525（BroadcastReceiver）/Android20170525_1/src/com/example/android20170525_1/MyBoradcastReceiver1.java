package com.example.android20170525_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBoradcastReceiver1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent intent) {
		// TODO Auto-generated method stub
		// 判断intent过滤条件并处理
		if ("GUANGBO2017052501".equals(intent.getAction())) {
			System.out.println("MyBoradcastReceiver1 接收到了广播GUANGBO2017052501");
		} else if ("GUANGBO2017052502".equals(intent.getAction())) {
			System.out.println("MyBoradcastReceiver1 接收到了广播GUANGBO2017052502");
		}
	}

}
