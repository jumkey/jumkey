package org.cafeboy.forever.receiver;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cafeboy.forever.MainActivity;
import org.cafeboy.forever.R;
import org.cafeboy.forever.util.Constants;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
	private Context context;
	private static String TAG = "alarmReceiver";

	public static final int NOTIFICATION_ID = 10001;

	/**
	 * 通过广播进行扫描，是否到达时间后再响起闹铃
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.ALARM_RECORD, Activity.MODE_PRIVATE);
		// 0时:0分
		String now = String.format("%tR", Calendar.getInstance().getTime());
		String time = sharedPreferences.getString(Constants.SEND_TIME, null);
		String haoma = sharedPreferences.getString(Constants.SEND_PHONE, null);
		String neirong = sharedPreferences.getString(Constants.SEND_TEXT, null);
		Log.d(TAG, now);
		Log.d(TAG, time);
		// 判断时间是否为空，并且是否与当前时间一样
		if (time != null && time.equals(now)) {
			sendMsg(context, haoma, neirong);
			showNotification();
		}
	}

	private void showNotification() {
		AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		// 通知栏提示
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		// contentTitle和contentText都是标准的Notification View的内容
		// Notification的内容标题，拖下来后看到的标题
		String contentTitle = context.getString(R.string.noticetitle);
		// Notification的内容
		String contentText = context.getString(R.string.sendsuccess);

		// Notification的Intent，即点击后转向的Activity
		Intent notificationIntent = new Intent(context, MainActivity.class);
		notificationIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

		// 创建Notifcation
		Notification notification = new Notification(R.drawable.message, null, System.currentTimeMillis());
		// 情景模式
		if (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL) {
			// 设定Notification出现时的声音，一般不建议自定义
			notification.defaults |= Notification.DEFAULT_SOUND;
			// 设定如何振动
			notification.defaults |= Notification.DEFAULT_VIBRATE;
		}
		// 指定Flag，Notification.FLAG_AUTO_CANCEL意指点击这个Notification后，立刻取消自身
		// 这符合一般的Notification的运作规范
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		// 显示这个notification
		mNotificationManager.notify(NOTIFICATION_ID, notification);
	}

	private void sendMsg(Context context, String number, String message) {
		SmsManager smsManager = SmsManager.getDefault();
		// 电话号码验证，简单的数据验证
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(number);
		if (!matcher.matches()) {
			// 弹出警告对话框
			// showDialog(DIALOG_NUMBER_ERROR);
			return;
		}
		if (message.length() > 70) {
			// 短信内容的字数大于70
			List<String> msgs = smsManager.divideMessage(message);
			for (String msg : msgs) {
				smsManager.sendTextMessage(number, null, msg, null, null);
			}
		} else {
			smsManager.sendTextMessage(number, null, message, null, null);
		}
		// 保存发送短信的内容到发件箱
		ContentValues values = new ContentValues();
		values.put("address", number);
		values.put("body", message);
		values.put("person", "");
		values.put("protocol", "0");
		values.put("read", "1");
		values.put("status", "-1");
		context.getContentResolver().insert(Uri.parse("content://sms/sent"), values);
	}
}
