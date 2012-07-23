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
	 * 这里有个小方法有必要说一下，在Service或Activity中我们可以写一个静态的方法来保留自己的实体。这样在其他的地方就可以获取到了。
	 * private static SleepMusicService sms = null; 用来存储自己的实体 在onCreate()中 使用sms
	 * = this;来存储实体 编写一个静态的getService()来返回实体就行了。
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

		// 获取AlarmManager
		AlarmManager aManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

		// 设置消息的响应
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