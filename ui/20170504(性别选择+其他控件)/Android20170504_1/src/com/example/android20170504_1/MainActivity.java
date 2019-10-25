package com.example.android20170504_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) this.findViewById(R.id.btn);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn:
			// creatSinge();//第一种方法
			creatSinge2();// 第二种方法
			break;

		default:
			break;
		}
	}

	Button btn_yes, btn_no;
	RadioButton rb1;
	RadioGroup rg;
	AlertDialog dialog;

	// 第一种方法
	public void creatSinge() {
		if (dialog == null) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			View view = View.inflate(this, R.layout.one, null);
			dialog = builder.setView(view).create();
			btn_yes = (Button) view.findViewById(R.id.btn_yes);
			btn_no = (Button) view.findViewById(R.id.btn_no);
			rb1 = (RadioButton) view.findViewById(R.id.rb1);
			btn_yes.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (rb1.isChecked()) {
						Toast.makeText(MainActivity.this, "您的性别为男",
								Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(MainActivity.this, "您的性别为女",
								Toast.LENGTH_SHORT).show();
					}
					dialog.dismiss();
				}
			});
			btn_no.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});

		}
		dialog.show();
	}

	// 第二种实现方法
	String sex = "男";

	public void creatSinge2() {

		if (dialog == null) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			View view = View.inflate(this, R.layout.one, null);
			dialog = builder.setView(view).create();
			btn_yes = (Button) view.findViewById(R.id.btn_yes);
			btn_no = (Button) view.findViewById(R.id.btn_no);
			rg = (RadioGroup) view.findViewById(R.id.rg);
			rb1 = (RadioButton) view.findViewById(R.id.rb1);
			rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup arg0, int id) {
					// TODO Auto-generated method stub
					switch (id) {
					case R.id.rb1:
						sex = "男";
						break;
					case R.id.rb2:
						sex = "女";
						break;
					default:
						break;
					}

				}
			});
			btn_yes.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub

					Toast.makeText(MainActivity.this, "您的性别为" + sex,
							Toast.LENGTH_SHORT).show();

					dialog.dismiss();
				}
			});
			btn_no.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});

		}
		sex = "男";
		rb1.setChecked(true);
		dialog.show();
	}
}
