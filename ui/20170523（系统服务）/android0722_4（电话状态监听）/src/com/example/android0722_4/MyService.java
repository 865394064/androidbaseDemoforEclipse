package com.example.android0722_4;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MyService extends Service {
	private TelephonyManager telephonyManager;
	private MediaRecorder recorder;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		telephonyManager.listen(new MyPhoneStateListene(),
				PhoneStateListener.LISTEN_CALL_STATE);

	}

	class MyPhoneStateListene extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);

			try {
				switch (state) {
				// 空闲状态
				case TelephonyManager.CALL_STATE_IDLE:
					if (recorder != null) {
						recorder.stop();
						recorder.reset(); // You can reuse the object by going
											// back to setAudioSource() step
						recorder.release();
					}

					break;
				// 响铃状态
				case TelephonyManager.CALL_STATE_RINGING:

					System.out.println(incomingNumber);
					// 新建一个录音机
					recorder = new MediaRecorder();
					// 设置音源
					recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
					// 设置文件输出格式
					recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					// 设置文件的编码
					recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
					// 输出文件的路劲
					recorder.setOutputFile("/sdcard/"
							+ System.currentTimeMillis() + incomingNumber
							+ ".3gp");
					recorder.prepare();

					break;
				// 通话中
				case TelephonyManager.CALL_STATE_OFFHOOK:
					if (recorder != null) {
						recorder.start();
					}

					break;

				default:
					break;
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
