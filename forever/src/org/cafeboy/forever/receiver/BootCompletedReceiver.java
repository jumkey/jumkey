package org.cafeboy.forever.receiver;

import org.cafeboy.forever.service.SleepAlarmService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			Intent myIntent = new Intent(context, SleepAlarmService.class);
			// myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			// ע�⣬������������ǣ�����������ʧ��
			context.startService(myIntent);
		}
	}
}
