package com.example.android20170504_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	ToggleButton tg;
	RatingBar ratingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tg();// 状态开关
		ratingBar = (RatingBar) this.findViewById(R.id.ratingbar);
		Toast.makeText(this, "当前" + ratingBar.getRating() + "颗星",
				Toast.LENGTH_SHORT).show();
		ratingBar
				.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

					@Override
					public void onRatingChanged(RatingBar arg0, float arg1,
							boolean arg2) {
						// TODO Auto-generated method stub
						// 只有当ratingBar的星星个数改变，才会执行
						Toast.makeText(MainActivity.this, "当前" + arg1 + "颗星",
								Toast.LENGTH_SHORT).show();
//						Toast.makeText(MainActivity.this,
//								"当前进度值为：" + ratingBar.getProgress(),
//								Toast.LENGTH_SHORT).show();
					}
				});
	}

	// 状态开关
	public void tg() {
		tg = (ToggleButton) findViewById(R.id.tg);
		if (tg.isChecked()) {
			Toast.makeText(this, "当前状态为打开", Toast.LENGTH_SHORT).show();
		}
		tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if (arg1) {
					Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
	}

}
