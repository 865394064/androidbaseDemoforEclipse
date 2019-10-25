package com.example.android20170513_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TwoActivity extends Activity {
	EditText et;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		et = (EditText) findViewById(R.id.et);
		btn = (Button) findViewById(R.id.btn2);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str = et.getText().toString().trim();
				if (TextUtils.isEmpty(str)) {
					Toast.makeText(TwoActivity.this, "内容为空", Toast.LENGTH_LONG)
							.show();

				} else {
					// 第二步：setResult()返回数据
					Intent i = new Intent();
					i.putExtra("str", str);
					setResult(1, i);// 返回参数（1为resultCode参数）
					finish();// 关闭界面
				}
			}
		});
	}

}
