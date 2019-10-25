package com.example.android20170427_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			createDialog();
			break;
		case R.id.btn2:
			createSingleChoiceDialog();
			break;

		default:
			break;
		}
	}

	// 创建普通对话框
	public void createDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("关闭界面");// 设置标题
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("确定关闭当前界面？");// 设置提示内容
		// 设置确定按钮
		builder.setPositiveButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				finish();// 关闭当前界面
				Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT)
						.show();
			}
		});
		// 设置确定按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT)
						.show();
			}
		});
		builder.show();// 显示对话框
	}

	String sex = "";

	// 创建单选对话框
	public void createSingleChoiceDialog() {
		sex = "男";
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("选择性别");// 设置标题
		builder.setIcon(R.drawable.ic_launcher);
		builder.setSingleChoiceItems(new String[] { "男", "女" }, 0,
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0) {
							sex = "男";
						} else {
							sex = "女";
						}
					}
				});
		// 设置确定按钮
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this, "您的性别为" + sex,
						Toast.LENGTH_SHORT).show();
			}
		});
		// 设置确定按钮
		builder.setNegativeButton("取消", null);
		builder.show();// 显示对话框
	}
}
