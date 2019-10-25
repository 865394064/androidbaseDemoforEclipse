package com.example.android20170525_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent intent) {
		// TODO Auto-generated method stub
		if ("GUANGBO2017052501".equals(intent.getAction())) {
			System.out.println("应用二 接收到了广播GUANGBO2017052501");
		} else if ("GUANGBO2017052502".equals(intent.getAction())) {
			System.out.println("应用二 接收到了广播GUANGBO2017052502");
		}
	}

}
