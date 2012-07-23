package org.cafeboy.forever;

import java.util.ArrayList;

import org.cafeboy.forever.service.SleepAlarmService;
import org.cafeboy.forever.util.Constants;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	private static String TAG = "mainActivity";
	TextView shijiantextview;
	TextView haomatextview;
	TextView neirongtextview;
	Button shezhibutton;
	Button wanchengbutton;
	Dialog dialog = null;
	private SharedPreferences sharedPreferences;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "Activity onCreate");

		final Intent sleepAlarmService = new Intent(MainActivity.this, SleepAlarmService.class);
		final boolean isRunning = isRunning(MainActivity.this, sleepAlarmService.getComponent().getClassName());

		shezhibutton = (Button) findViewById(R.id.shezhibutton);
		shezhibutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog();
			}
		});
		wanchengbutton = (Button) findViewById(R.id.wanchengbutton);
		wanchengbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isRunning) {
					// 停止服务
					stopService(sleepAlarmService);
				} else {
					/**
					 * 在Service启动之前可以使用Intent来传递参数给Service ，方法如下 目前的代码只是演示，与功能无关
					 */
					Bundle setting = new Bundle();
					setting.putString("TIME_SETTING", "5s");
					// 在Service中使用"TIME_SETTING"这个标签就可以从Intent取出5s 这个字符串了
					sleepAlarmService.putExtras(setting);
					startService(sleepAlarmService);
				}
				finish();
			}
		});
		if (isRunning) {
			wanchengbutton.setText(R.string.stop);
		} else {
			wanchengbutton.setText(R.string.start);
		}
		shijiantextview = (TextView) findViewById(R.id.shijiantextview);
		haomatextview = (TextView) findViewById(R.id.haomatextview);
		neirongtextview = (TextView) findViewById(R.id.neirongtextview);
		sharedPreferences = getSharedPreferences(Constants.ALARM_RECORD, Activity.MODE_PRIVATE);
		String time = sharedPreferences.getString(Constants.SEND_TIME, null);
		String haoma = sharedPreferences.getString(Constants.SEND_PHONE, null);
		String neirong = sharedPreferences.getString(Constants.SEND_TEXT, null);
		shijiantextview.setText(getString(R.string.sendtime, time));
		haomatextview.setText(getString(R.string.sendphone, haoma));
		neirongtextview.setText(getString(R.string.sendtext, neirong));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void dialog() {
		View view = getLayoutInflater().inflate(R.layout.shijian, null);

		final TimePicker timePicker = (TimePicker) view.findViewById(R.id.timepicker);
		final EditText phoneedittext = (EditText) view.findViewById(R.id.phoneedittext);
		final EditText textedittext = (EditText) view.findViewById(R.id.textedittext);
		timePicker.setIs24HourView(true);

		String haoma = sharedPreferences.getString(Constants.SEND_PHONE, null);
		String neirong = sharedPreferences.getString(Constants.SEND_TEXT, null);
		phoneedittext.setText(haoma);
		textedittext.setText(neirong);

		new AlertDialog.Builder(this).setTitle(R.string.setting).setView(view).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				timePicker.clearFocus();
				String timeStr = String.format("%1$02d:%2$02d", timePicker.getCurrentHour(), timePicker.getCurrentMinute());

				shijiantextview.setText(getString(R.string.sendtime, timeStr));
				haomatextview.setText(getString(R.string.sendphone, phoneedittext.getText().toString()));
				neirongtextview.setText(getString(R.string.sendtext, textedittext.getText().toString()));

				sharedPreferences.edit().putString(Constants.SEND_TIME, timeStr).commit();
				sharedPreferences.edit().putString(Constants.SEND_PHONE, phoneedittext.getText().toString()).commit();
				sharedPreferences.edit().putString(Constants.SEND_TEXT, textedittext.getText().toString()).commit();

			}

		}).setNegativeButton(android.R.string.cancel, null).show();

	}

	public boolean isRunning(Context c, String serviceName) {
		ActivityManager myAM = (ActivityManager) c.getSystemService(Context.ACTIVITY_SERVICE);

		ArrayList<RunningServiceInfo> runningServices = (ArrayList<RunningServiceInfo>) myAM.getRunningServices(Integer.MAX_VALUE);
		// 获取最多40个当前正在运行的服务，放进ArrList里,以现在手机的处理能力，要是超过40个服务，估计已经卡死，所以不用考虑超过40个该怎么办
		for (int i = 0; i < runningServices.size(); i++) {// 循环枚举对比
			if (runningServices.get(i).service.getClassName().equals(serviceName)) {
				return true;
			}
		}
		return false;
	}
}
