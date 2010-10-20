package com.demo.android.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Us extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.us);
		findViews();
		setListensers();
	}

	private Button button_calc;
	private Spinner field_feet;
	private Spinner field_inch;
	private EditText field_weight;
	private TextView view_result;
	private TextView view_suggest;

	private void findViews() {
		// Log.d(TAG, "find Views");
		button_calc = (Button) findViewById(R.id.submit);
		field_feet = (Spinner) findViewById(R.id.feet);
		field_inch = (Spinner) findViewById(R.id.inch);
		field_weight = (EditText) findViewById(R.id.weight);
		view_result = (TextView) findViewById(R.id.result);
		view_suggest = (TextView) findViewById(R.id.suggest);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.feets, android.R.layout.simple_spinner_item);
		adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		field_feet.setAdapter(adapter);

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.inches, android.R.layout.simple_spinner_item);
		adapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		field_inch.setAdapter(adapter2);
	}

	// Listen for button clicks
	private void setListensers() {
		// Log.d(TAG, "set Listensers");
		// listen Array setOnItemClickListener
		field_feet.setOnItemSelectedListener(getFeet);
		field_inch.setOnItemSelectedListener(getInch);
		button_calc.setOnClickListener(calcUsBMI);
		field_feet.setSelection(3);
	}

	private int feet;
	private int inch;

	private Spinner.OnItemSelectedListener getFeet = new Spinner.OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			feet = parent.getSelectedItemPosition() + 2;
		}

		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	private Spinner.OnItemSelectedListener getInch = new Spinner.OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			inch = parent.getSelectedItemPosition() + 1;
		}

		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	private Button.OnClickListener calcUsBMI = new Button.OnClickListener() {
		public void onClick(View v) {
			DecimalFormat nf = new DecimalFormat("0.00");
			try {
				double height = (feet * 12 + inch) * 2.54 / 100;
				double weight = Double.parseDouble(field_weight.getText()
						.toString()) * 0.45359;
				double BMI = weight / (height * height);
				// Present result
				view_result.setText(getText(R.string.bmi_result)
						+ nf.format(BMI));

				// Give health advice
				if (BMI > 25) {
					view_suggest.setText(R.string.advice_heavy);
				} else if (BMI < 20) {
					view_suggest.setText(R.string.advice_light);
				} else {
					view_suggest.setText(R.string.advice_average);
				}
			} catch (Exception obj) {
				Toast.makeText(Us.this, "打錯了嗎？只能輸入數字喔", Toast.LENGTH_SHORT)
						.show();
			}
		}
	};

	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_bmi = Menu.FIRST + 1;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// Log.d(TAG, "open Menu");
		menu.add(0, MENU_ABOUT, 0, R.string.about_label);
		menu.add(0, MENU_bmi, 0, R.string.norm_label);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		// Log.d(TAG, "select Menu Item");
		switch (item.getItemId()) {
		case MENU_ABOUT:
			openOptionsDialog();
			break;
		case MENU_bmi:
			Intent intent = new Intent();
			intent.setClass(Us.this, Bmi.class);
			startActivity(intent);
			// finish();
			break;
		}
		return true;
	}

	private void openOptionsDialog() {
		// Log.d(TAG, "open Dialog");
		new AlertDialog.Builder(this).setTitle(R.string.about_title)// .setView(view)
				.setMessage(R.string.about_msg).setPositiveButton(
						R.string.ok_label,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
							}
						}).show();
	}
}
