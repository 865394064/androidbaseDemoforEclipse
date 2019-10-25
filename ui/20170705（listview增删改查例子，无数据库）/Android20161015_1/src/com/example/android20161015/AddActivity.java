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

public class AddActivity extends Activity {
	EditText et_name, et_age, et_qq;
	Button btn_add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		et_name = (EditText) this.findViewById(R.id.et_name);
		et_age = (EditText) this.findViewById(R.id.et_age);
		et_qq = (EditText) this.findViewById(R.id.et_qq);
		btn_add = (Button) this.findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = et_name.getText().toString().trim();
				String age = et_age.getText().toString().trim();
				String qq = et_qq.getText().toString().trim();
				if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)
						|| TextUtils.isEmpty(qq)) {
					Toast.makeText(AddActivity.this, "请填写完整信息",
							Toast.LENGTH_LONG).show();
					return;
				}
				User user = new User(name, age, qq);
				Intent i = new Intent();
				i.putExtra("user", user);
				setResult(101, i);
				finish();
			}
		});

	}

}
