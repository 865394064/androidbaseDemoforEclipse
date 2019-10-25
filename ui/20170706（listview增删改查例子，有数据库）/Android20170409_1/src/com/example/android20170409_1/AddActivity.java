package com.example.android20170409_1;

import com.example.shuju.UserDAO;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {
	EditText et_name, et_age, et_qq;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		et_name = (EditText) findViewById(R.id.et_name);
		et_age = (EditText) findViewById(R.id.et_age);
		et_qq = (EditText) findViewById(R.id.et_qq);
		btn = (Button) findViewById(R.id.btn_add);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = et_name.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				String qq = et_qq.getText().toString().trim();
				if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)
						|| TextUtils.isEmpty(qq)) {
					Toast.makeText(AddActivity.this, "请输入完整信息",
							Toast.LENGTH_SHORT).show();
				} else {
					ContentValues cv = new ContentValues();
					cv.put("name", name);
					cv.put("age", age);
					cv.put("qq", qq);
					UserDAO dao = new UserDAO(AddActivity.this);
					boolean b = dao.insert(cv);
					if (b) {
						Toast.makeText(AddActivity.this, "插入数据成功",
								Toast.LENGTH_SHORT).show();
						sendBroadcast(new Intent("UPDATE"));
					} else {
						Toast.makeText(AddActivity.this, "插入数据失败",
								Toast.LENGTH_SHORT).show();
					}
					finish();
				}
			}
		});

	}

}
