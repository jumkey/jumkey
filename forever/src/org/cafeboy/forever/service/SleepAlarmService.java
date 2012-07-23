package org.cafeboy.forever.service;

import org.cafeboy.forever.receiver.AlarmReceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SleepAlarmService extends Service {
	private static String TAG = "sleepAlarmService";
	private static SleepAlarmService sms = null;

	public static Service getService() {
		return sms;
	}

	/**
	 * �����и�С�����б�Ҫ˵һ�£���Service��Activity�����ǿ���дһ����̬�ķ����������Լ���ʵ�塣�����������ĵط��Ϳ��Ի�ȡ���ˡ�
	 * private static SleepMusicService sms = null; �����洢�Լ���ʵ�� ��onCreate()�� ʹ��sms
	 * = this;���洢ʵ�� ��дһ����̬��getService()������ʵ������ˡ�
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		sms = this;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.d(TAG, "Service onStart");

		// ��ȡAlarmManager
		AlarmManager aManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

		// ������Ϣ����Ӧ
		Intent ii = new Intent(this, AlarmReceiver.class);
		ii.setAction("AlarmReceiver");
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, ii, 0);
		// aManager.set(AlarmManager.RTC, calendar.getTimeInMillis(),
		// pendingIntent);
		aManager.setRepeating(AlarmManager.RTC, 0, 60 * 1000, pendingIntent);
	}

	@Override
	public void onDestroy() {
		AlarmManager am = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
		Intent ii = new Intent(this, AlarmReceiver.class);
		ii.setAction("AlarmReceiver");
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, ii, 0);
		am.cancel(pi);
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}