package org.cafeboy.lockscreenwidget;

import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class LockWidget extends AppWidgetProvider {
	private static final String TAG = LockWidget.class.getSimpleName();

	public void onDisabled(Context context) {
	}

	public void onEnabled(Context context) {
	}

	public void onReceive(Context context, Intent intent) {
		String str = intent.getAction();
		Log.d(TAG, "LockWidget::onReceive(" + str + ")");
		if (intent.getAction() != null) {
			if (!AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(str)) {
				super.onReceive(context, intent);
			} else {
				int i = intent.getExtras().getInt("appWidgetId", 0);
				if (i != 0) {
					int[] appWidgetIds = new int[1];
					appWidgetIds[0] = i;
					onDeleted(context, appWidgetIds);
				}
			}
		} else {
			context.startService(new Intent(context, UpdateService.class));
		}
	}

	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		context.startService(new Intent(context, UpdateService.class));
	}

	public static class UpdateService extends IntentService {
		public static final String RE_ENABLE = "reenable";
		public static final String STATE = "state";

		public UpdateService() {
			// FIXME super();
			super("LockWidget$UpdateService");
		}

		private RemoteViews buildUpdate(Context context) {
			Log.d(TAG, "UpdateService::buildUpdate");
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
//			remoteViews.setImageViewResource(R.id.widget_icon, R.drawable.ic_launcher);
//			remoteViews.setTextViewText(R.id.title, getString(R.string.lock));
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(this, LockScreenAdmin.LockActivity.class), 0);
//			remoteViews.setOnClickPendingIntent(R.id.widget_icon, pendingIntent);
			remoteViews.setOnClickPendingIntent(R.id.widget_layout, pendingIntent);
			return remoteViews;
		}

		public void onHandleIntent(Intent intent) {
			Log.d(TAG, "UpdateService::onHandleIntent");
			ComponentName componentName = new ComponentName(this, LockWidget.class);
			AppWidgetManager.getInstance(this).updateAppWidget(componentName, buildUpdate(this));
		}
	}
}
