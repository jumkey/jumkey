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
	 * ͨ���㲥����ɨ�裬�Ƿ񵽴�ʱ�������������
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.ALARM_RECORD, Activity.MODE_PRIVATE);
		// 0ʱ:0��
		String now = String.format("%tR", Calendar.getInstance().getTime());
		String time = sharedPreferences.getString(Constants.SEND_TIME, null);
		String haoma = sharedPreferences.getString(Constants.SEND_PHONE, null);
		String neirong = sharedPreferences.getString(Constants.SEND_TEXT, null);
		Log.d(TAG, now);
		Log.d(TAG, time);
		// �ж�ʱ���Ƿ�Ϊ�գ������Ƿ��뵱ǰʱ��һ��
		if (time != null && time.equals(now)) {
			sendMsg(context, haoma, neirong);
			showNotification();
		}
	}

	private void showNotification() {
		AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		// ֪ͨ����ʾ
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		// contentTitle��contentText���Ǳ�׼��Notification View������
		// Notification�����ݱ��⣬�������󿴵��ı���
		String contentTitle = context.getString(R.string.noticetitle);
		// Notification������
		String contentText = context.getString(R.string.sendsuccess);

		// Notification��Intent���������ת���Activity
		Intent notificationIntent = new Intent(context, MainActivity.class);
		notificationIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

		// ����Notifcation
		Notification notification = new Notification(R.drawable.message, null, System.currentTimeMillis());
		// �龰ģʽ
		if (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL) {
			// �趨Notification����ʱ��������һ�㲻�����Զ���
			notification.defaults |= Notification.DEFAULT_SOUND;
			// �趨�����
			notification.defaults |= Notification.DEFAULT_VIBRATE;
		}
		// ָ��Flag��Notification.FLAG_AUTO_CANCEL��ָ������Notification������ȡ������
		// �����һ���Notification�������淶
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		// ��ʾ���notification
		mNotificationManager.notify(NOTIFICATION_ID, notification);
	}

	private void sendMsg(Context context, String number, String message) {
		SmsManager smsManager = SmsManager.getDefault();
		// �绰������֤���򵥵�������֤
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(number);
		if (!matcher.matches()) {
			// ��������Ի���
			// showDialog(DIALOG_NUMBER_ERROR);
			return;
		}
		if (message.length() > 70) {
			// �������ݵ���������70
			List<String> msgs = smsManager.divideMessage(message);
			for (String msg : msgs) {
				smsManager.sendTextMessage(number, null, msg, null, null);
			}
		} else {
			smsManager.sendTextMessage(number, null, message, null, null);
		}
		// ���淢�Ͷ��ŵ����ݵ�������
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
