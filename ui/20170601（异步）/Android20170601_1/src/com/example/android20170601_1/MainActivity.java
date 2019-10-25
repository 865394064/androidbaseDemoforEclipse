package com.example.android20170601_1;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	ProgressBar progressbar;
	Button btn1, btn2;
	int num = 0;
	MyAsyncTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		progressbar = (ProgressBar) findViewById(R.id.progressbar);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn2.setEnabled(false);// 设置按钮不能被点击
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.btn1:// 启动异步线程
			btn1.setEnabled(false);
			btn2.setEnabled(true);
			task = new MyAsyncTask();
			task.execute();// 启动异步，无参数
			break;
		case R.id.btn2:// 取消异步线程
			btn1.setEnabled(true);
			btn2.setEnabled(false);
			task.cancel(false);// 取消异步

			break;

		default:
			break;
		}
	}

	/*
	 * Params：任务执行器需要的数据类型，传递给doInBackground(Params)的类型即后台运行任务的参数类型
	 * Progress：后台计算中使用的进度单位数据类型，传递给onProgressUpdate(Progress)的参数类型
	 * Result：后台计算返回结果的数据类型，传递给onPostExecute(Result)的参数类型
	 * 有些参数是可以设置为不使用的，只要传递为void类型即可
	 */
	class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
		// 主方法，在主线程之外执行，用来处理耗时操作
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			while (num < 100) {
				if (task.isCancelled()) {
					break;// 异步取消或者异常时无法回调onPostExecute（），在onCancelled()处理事件
				}
				try {
					num++;
					publishProgress(num);// 调用onProgressUpdate（）
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}

		// 只有调用了publishProgress(Progress...)才会执行，在主线程执行
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			progressbar.setProgress(values[0]);// 更新进度条的进度
			tv.setText("当前进度值为" + values[0] + "%");
			super.onProgressUpdate(values);
		}

		// doInBackground（）执行完毕后回调，用来对结果进行处理，在主线程执行
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			tv.setText("异步执行完毕");
			num = 0;
			progressbar.setProgress(0);
			btn1.setEnabled(true);
			btn2.setEnabled(false);
			super.onPostExecute(result);
		}

		// 取消异步时回调此方法
		@Override
		protected void onCancelled() {
			// TODO Auto-generated method stub
			super.onCancelled();
			tv.setText("异步已取消");
		}

	}

}
