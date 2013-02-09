package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CurrecyConverterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.currency_converter);

		final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, getResources()
						.getStringArray(R.array.currencies));
		spinner1.setAdapter(adapter);

		final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

		spinner2.setAdapter(adapter);

		Button button1 = (Button) findViewById(R.id.button1);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				EditText editText1 = (EditText) findViewById(R.id.editText1);
				String obtainedText = editText1.getText().toString();
				double obtainedNumber = Double.parseDouble(obtainedText);

				String inputCurrency = (String) spinner1.getSelectedItem();
				String outputCurrency = (String) spinner2.getSelectedItem();
				double convertedNumber = getConvertedNumber(obtainedNumber,
						inputCurrency, outputCurrency);

				EditText editText2 = (EditText) findViewById(R.id.editText2);
				editText2.setText(String.valueOf(convertedNumber));
			}
		});
	}

	private double getConvertedNumber(double obtainedNumber,
			String inputCurrency, String outputCurrency) {
		return obtainedNumber
				* getCurrencyConversionRate(inputCurrency, outputCurrency);
	}

	private double getCurrencyConversionRate(String inputCurrency,
			String outputCurrency) {
		if (outputCurrency.equalsIgnoreCase("inr")
				&& inputCurrency.equalsIgnoreCase("usd")) {
			return 50;
		}

		return 1;
	}
}
