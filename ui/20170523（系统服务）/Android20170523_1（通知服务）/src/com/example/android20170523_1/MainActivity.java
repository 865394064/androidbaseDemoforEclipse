package com.example.android20170523_1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btn;
	PendingIntent pendingIntent;
	Notification noti;
	NotificationManager manager;
	int num = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent i = new Intent(this, TwoActivity.class);
		// 创建延时意图
		pendingIntent = PendingIntent.getActivity(this, 0, i,
				PendingIntent.FLAG_UPDATE_CURRENT);
		// 得到通知栏服务
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				createNotification();
				Intent alarmChanged = new Intent("android.intent.action.ALARM_CHANGED");  
		        alarmChanged.putExtra("alarmSet", true); 
		       sendBroadcast(alarmChanged); 
			}
		});
	}
	public void createNotification() {
		noti = new Notification();// 创建消息
		noti.icon = R.drawable.ic_launcher;// 设置消息的图标
		noti.tickerText = "您有新的消息";// 设置预览信息
		noti.when = System.currentTimeMillis();// 设置消息的时间为当前的系统时间
		noti.defaults = Notification.DEFAULT_SOUND; // 默认通知的声音
		noti.flags = Notification.FLAG_AUTO_CANCEL;// 设置消息标题滚动自动取消
		// 设置消息的显示内容
		noti.setLatestEventInfo(this, "天气提示", "今天天气不错，适合出门", pendingIntent);
		manager.notify(num++, noti);// 唤醒消息（把消息显示在通知栏上）:第一个参数（同一个数值的消息只显示最后一个）

	}
}
