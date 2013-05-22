package org.cafeboy.widget.lockscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class HelpActivity extends Activity implements OnClickListener {
	public void onClick(View view) {
		finish();
	}

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(1);
		setContentView(R.layout.help);
		((LinearLayout) findViewById(R.id.main_layout)).setOnClickListener(this);
	}

	public void onPause() {
		super.onPause();
		finish();
	}
}
