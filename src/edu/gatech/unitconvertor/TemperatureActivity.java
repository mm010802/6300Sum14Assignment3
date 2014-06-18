package edu.gatech.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class TemperatureActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	//Auto generate method
	super .onCreate(savedInstanceState);
	// Use setContentView to open the layout
	setContentView(R.layout.activity_temperature);
	
	// Display the < to indicate customer that they can go to previous screen
	getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	// Return to the home page
	public boolean onOptionsItemSelected(MenuItem item) {
		// Evaluate what option was selected by the customer
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	};
	
	// Method to convert from Celisus to Fahrenheit
	public String csToFahrenheit(double Celisus) {
		double Fahrenheit = (Celisus * 9/5) + 32;
		return String.valueOf(Fahrenheit);
	}
	
	// Method to convert from Farenheit to Celisus
	public String fahrenheitToCs(double Fahrenheit) {
		double Celisus = (Fahrenheit - 32) * 5/9;
		return String.valueOf(Celisus);
	}
	// handleClick: this method is invoked from the layout activity_temperature when either radio button is clicked
	public void handleClick(View view) {
		// Check the status of the radio button that is being clicked 
		boolean checked = ((RadioButton) view).isChecked();
		// Get reference for our text box and we use the id to get the reference
		// R is used to access the id and on that id the editText 1
		EditText txt = (EditText) findViewById(R.id.editText1);
		// convert txt to string and then parse to double
		double temperature = Double.parseDouble(txt.getText().toString());
		
		// The code below allow us to perform specific conversion depending on radio button selected
		//Get id
		switch(view.getId()) {
		case R.id.radio0:
			// if radio button corresponding to Fahrenheit is clicked
			if (checked)
				// that means we need to convert from Celisus to Fahrenheit
				// csToFahrenheit method will be invoked to convert from Cs to Fahrenheit
				// and the value will be returned on the txt field
					txt.setText(csToFahrenheit(temperature));
			break;
			
		case R.id.radio1:
			// if radio button corresponding to Celisus is clicked
			if (checked)
				// that means we need to convert from Fahrenheit to Celisus
				// farenheitToCs method will be invoked to convert from Farenheit to Celisus
				// and the value will be returned on the txt field
					txt.setText(fahrenheitToCs(temperature));
			break;	
			
		}
		
	}
}
