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

public class UpdateActivity extends Activity {
	EditText et_name, et_age, et_qq;
	Button btn;
	int id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		et_name = (EditText) findViewById(R.id.et_name);
		et_age = (EditText) findViewById(R.id.et_age);
		et_qq = (EditText) findViewById(R.id.et_qq);
		getData();
		btn = (Button) findViewById(R.id.btn_update);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = et_name.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				String qq = et_qq.getText().toString().trim();
				if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)
						|| TextUtils.isEmpty(qq)) {
					Toast.makeText(UpdateActivity.this, "请输入完整信息",
							Toast.LENGTH_SHORT).show();
				} else {
					ContentValues cv = new ContentValues();
					cv.put("name", name);
					cv.put("age", age);
					cv.put("qq", qq);
					UserDAO dao = new UserDAO(UpdateActivity.this);
					boolean b = dao
							.update(cv, "id=?", new String[] { id + "" });
					if (b) {
						Toast.makeText(UpdateActivity.this, "修改数据成功",
								Toast.LENGTH_SHORT).show();
						sendBroadcast(new Intent("UPDATE"));
					} else {
						Toast.makeText(UpdateActivity.this, "修改数据失败",
								Toast.LENGTH_SHORT).show();
					}
					finish();
				}
			}
		});

	}

	public void getData() {
		Intent i = this.getIntent();
		User user = (User) i.getSerializableExtra("user");
		et_name.setText(user.getName());
		et_age.setText(user.getAge());
		et_qq.setText(user.getQq());
		id = user.getId();
	}

}
