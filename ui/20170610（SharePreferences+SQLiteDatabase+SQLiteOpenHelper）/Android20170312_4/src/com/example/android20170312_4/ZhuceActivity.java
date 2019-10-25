package com.example.android20170312_4;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZhuceActivity extends Activity {
	EditText et_name, et_mima, et_mima2;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuce);
		et_name = (EditText) findViewById(R.id.et_name);
		et_mima = (EditText) findViewById(R.id.et_mima);
		et_mima2 = (EditText) findViewById(R.id.et_mima2);
		btn = (Button) findViewById(R.id.btn_zhuce);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = et_name.getText().toString().trim();
				String mima = et_mima.getText().toString().trim();
				String mima2 = et_mima2.getText().toString().trim();
				if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mima)
						|| TextUtils.isEmpty(mima2)) {
					Toast.makeText(ZhuceActivity.this, "不能为空",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (!mima.equals(mima2)) {
					Toast.makeText(ZhuceActivity.this, "两次密码不一致",
							Toast.LENGTH_SHORT).show();
					return;
				}
				// 获取到SharedPreferences对象
				SharedPreferences sp = getSharedPreferences("data",
						MODE_PRIVATE);
				// 获取到编辑器
				Editor edit = sp.edit();
				// 存储数据
				edit.putString("name", name);
				edit.putString("mima", mima);
				// 提交数据,必须的步骤
				edit.commit();
				finish();
			}
		});

	}

}
