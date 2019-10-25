package com.example.android20170518_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.one);
		super.onCreate(savedInstanceState);
		
	}

	public void click(View v) {
		Button btn = (Button) v;
		switch (v.getId()) {
		case R.id.btn1:

			break;
		case R.id.btn2:

			break;
		case R.id.btn3:

			break;
		default:
			break;
		}
		Toast.makeText(this, btn.getText().toString(), Toast.LENGTH_SHORT)
				.show();
	}
}
