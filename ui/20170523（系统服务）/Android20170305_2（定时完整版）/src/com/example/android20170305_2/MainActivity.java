package com.example.android20170305_2;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv;
	Calendar calender;// 时间对象
	PendingIntent pIntent;
	AlarmManager manager;// 定时服务

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		calender = Calendar.getInstance();// 实例化时间对象

		Intent i = new Intent(this, TwoActivity.class);
		pIntent = PendingIntent.getActivity(this, 0, i,
				PendingIntent.FLAG_UPDATE_CURRENT);
		manager = (AlarmManager) getSystemService(ALARM_SERVICE);
	}

	public void click(View v) {
		switch (v.getId()) {
		// 显示时间对话框并设置闹钟
		case R.id.btn1:

			int hour = calender.get(Calendar.HOUR_OF_DAY);// 得到calender对象里面的小时数
			int min = calender.get(Calendar.MINUTE);// 得到calender对象里面的分钟数
			/**
			 * 设置时间对话框并显示,第二个参数为监听时间,第三个参数为对话框显示的小时数,
			 * 第四个参数为对话框显示的分钟数,第五个参数显示的是对话框是否为24小时制.
			 */
			new TimePickerDialog(this, new OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker arg0, int hourof, int minof) {
					// TODO Auto-generated method stub
					calender.setTimeInMillis(System.currentTimeMillis());// 设置时间为当前的系统时间
					calender.set(Calendar.HOUR_OF_DAY, hourof);// 设置小时数
					calender.set(Calendar.MINUTE, minof);// 设置分钟
					calender.set(Calendar.SECOND, 0);// 设置秒
					calender.set(Calendar.MILLISECOND, 0);// 设置毫秒
					// 一次定时
					// manager.set(AlarmManager.RTC_WAKEUP,
					// calender.getTimeInMillis(), pIntent);
					// 多次定时
					manager.setRepeating(AlarmManager.RTC_WAKEUP,
							calender.getTimeInMillis(), 5 * 1000, pIntent);
					tv.setText("设置了闹钟,时间为" + hourof + ":" + minof);
				}
			}, hour, min, true).show();
			break;
		case R.id.btn2:
			// 取消闹钟
			manager.cancel(pIntent);
			tv.setText("取消了闹钟");
			break;

		default:
			break;
		}
	}
}
