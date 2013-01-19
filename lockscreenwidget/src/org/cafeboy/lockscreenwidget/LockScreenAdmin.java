package org.cafeboy.lockscreenwidget;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LockScreenAdmin extends DeviceAdminReceiver {
	public static class LockActivity extends Activity {
		static final int RESULT_ENABLE = 1;
		ComponentName mLockScreenAdmin;

		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			switch (requestCode) {
			default:
				super.onActivityResult(requestCode, resultCode, data);
			case 1:
			}
		}

		protected void onCreate(Bundle bundle) {
			super.onCreate(bundle);
			DevicePolicyManager policyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
			this.mLockScreenAdmin = new ComponentName(this, LockScreenAdmin.class);
			if (!policyManager.isAdminActive(this.mLockScreenAdmin)) {
				Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
				intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, this.mLockScreenAdmin);
				intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, getString(R.string.extra_add_explanation));
				startActivityForResult(intent, 1);
			} else {
				policyManager.lockNow();
			}
			finish();
		}
	}
}
