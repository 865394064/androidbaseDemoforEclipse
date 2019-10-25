package com.example.android20170312_4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText et_name, et_mima;
	String old_name, old_mima;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name = (EditText) findViewById(R.id.et_name);
		et_mima = (EditText) findViewById(R.id.et_mima);

	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			// 获取到SharedPreferences的对象
			SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
			// 获取到SharedPreferences里面存储的数据
			old_name = sp.getString("name", "");
			old_mima = sp.getString("mima", "");
			String name = et_name.getText().toString().trim();
			String mima = et_mima.getText().toString().trim();
			if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mima)) {
				Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT)
						.show();
				return;
			}
			if (name.equals(old_name) && mima.equals(old_mima)) {
				Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(MainActivity.this, "用户名或者密码有误",
						Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_zhuce:
			startActivity(new Intent(this, ZhuceActivity.class));
			break;

		default:
			break;
		}
	}
}
