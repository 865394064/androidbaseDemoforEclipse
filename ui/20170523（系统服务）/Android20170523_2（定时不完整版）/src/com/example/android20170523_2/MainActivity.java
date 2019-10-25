package com.example.android20170523_2;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	Calendar calendar;
	AlarmManager manager;
	PendingIntent pendingIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		calendar = Calendar.getInstance();// 初始化Calendar对象，设置系统当前时间为初始值
		Intent i = new Intent(this, TwoActivity.class);
		pendingIntent = PendingIntent.getActivity(this, 0, i,
				PendingIntent.FLAG_UPDATE_CURRENT);
		manager = (AlarmManager) this.getSystemService(ALARM_SERVICE);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 启动定时
			int hour_calender = calendar.get(Calendar.HOUR);
			int minute_calender = calendar.get(Calendar.MINUTE);
			new TimePickerDialog(this,
					new TimePickerDialog.OnTimeSetListener() {

						@Override
						public void onTimeSet(TimePicker arg0, int hour,
								int minute) {
							// TODO Auto-generated method stub
							calendar.setTimeInMillis(System.currentTimeMillis());// 设置为当前系统时间
							calendar.set(Calendar.HOUR_OF_DAY, hour);// 设置小时数
							calendar.set(Calendar.MINUTE, minute);// 设置分钟数
							calendar.set(Calendar.SECOND, 0);// 设置秒数
							calendar.set(Calendar.MILLISECOND, 0);// 设置微秒
							System.out.println("calendar.getTimeInMillis()=="
									+ calendar.getTime());
							// 设置一次定时
							// manager.set(AlarmManager.RTC_WAKEUP,
							// calendar.getTimeInMillis(), pendingIntent);

							// 设置重复定时
							manager.setRepeating(AlarmManager.RTC_WAKEUP,
									calendar.getTimeInMillis(), 3 * 1000,
									pendingIntent);

						}
					}, hour_calender, minute_calender, true).show();
			break;
		case R.id.btn2:// 取消定时

			break;
		default:
			break;
		}
	}

	public void setCalendar() {
		calendar.set(Calendar.HOUR_OF_DAY, 10);// 设置小时数
		calendar.set(Calendar.MINUTE, 8);// 设置分钟数
		calendar.set(Calendar.SECOND, 23);// 设置秒数
		System.out.println("calendar里的小时数=" + calendar.get(Calendar.HOUR));
		System.out.println("calendar里的分钟数=" + calendar.get(Calendar.MINUTE));
		System.out.println("calendar里的秒数=" + calendar.get(Calendar.SECOND));
	}
}
