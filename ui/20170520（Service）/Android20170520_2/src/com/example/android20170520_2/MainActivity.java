package com.example.android20170520_2;

import com.example.android20170520_2.MyService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	MyBinder myBinder;
	Connection conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		conn = new Connection();// 创建内部类
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 绑定服务
			Intent i = new Intent(this, MyService.class);
			bindService(i, conn, BIND_AUTO_CREATE);
			Toast.makeText(this, "服务绑定成功", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn2:// 调用已绑定服务的方法
			if (myBinder == null) {
				Toast.makeText(this, "服务未绑定", Toast.LENGTH_SHORT).show();
			} else {
				myBinder.want("逛超市，然后游泳");
			}
			break;
		case R.id.btn3:// 解除绑定
			if (myBinder == null) {
				Toast.makeText(this, "服务未绑定", Toast.LENGTH_SHORT).show();
			} else {
				unbindService(conn);
				myBinder = null;
				Toast.makeText(this, "服务解除绑定成功", Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
	}

	class Connection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder binder) {
			// TODO Auto-generated method stub
			myBinder = (MyBinder) binder;
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub

		}

	}
}
