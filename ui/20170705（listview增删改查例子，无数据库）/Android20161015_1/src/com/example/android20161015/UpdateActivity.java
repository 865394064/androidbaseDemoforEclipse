package com.example.android20161015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity {
	EditText et_name, et_age, et_qq;
	Button btn_update;
	int id = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		et_name = (EditText) this.findViewById(R.id.et_name);
		et_age = (EditText) this.findViewById(R.id.et_age);
		et_qq = (EditText) this.findViewById(R.id.et_qq);
		getData();// 获取传递过来的数据并显示
		btn_update = (Button) this.findViewById(R.id.btn_update);
		btn_update.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = et_name.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				String qq = et_qq.getText().toString().trim();
				if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)
						|| TextUtils.isEmpty(qq)) {
					Toast.makeText(UpdateActivity.this, "请填写完整信息",
							Toast.LENGTH_LONG).show();
					return;
				}
				User user = new User(name, age, qq);
				Intent i = new Intent();
				i.putExtra("user", user);
				i.putExtra("id", id);
				setResult(102, i);
				finish();
			}
		});

	}

	public void getData() {
		Intent i = this.getIntent();
		if (i != null) {
			User user = (User) i.getSerializableExtra("user");
			et_name.setText(user.getName());
			et_age.setText(user.getAge());
			et_qq.setText(user.getQq());
			id = i.getIntExtra("id", 0);
		}

	}
}
