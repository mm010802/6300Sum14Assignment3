package edu.gatech.unitconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class WeightActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	//Auto generate method
	super .onCreate(savedInstanceState);
	// Use setContentView to open the layout
	setContentView(R.layout.activity_weight);
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
	
	// Method to convert from Kilograms to Pounds
	public String kgToPounds(double Kilograms) {
		double Pounds = Kilograms * 2.2046;
		return String.valueOf(Pounds);
	}
	
	// Method to convert from Pounds to Kilograms
	public String poundsToKg(double Pounds) {
		double Kilograms = Pounds/2.2046;
		return String.valueOf(Kilograms);
	}
	// handleClick: this method is invoked from the layout activity_weight when either radio button is clicked
	public void handleClick(View view) {
		// Check the status of the radio button that is being clicked 
		boolean checked = ((RadioButton) view).isChecked();
		// Get reference for our text box and we use the id to get the reference
		// R is used to access the id and on that id the editText 1
		EditText txt = (EditText) findViewById(R.id.editText1);
		// convert txt to string and then parse to double
		double weight = Double.parseDouble(txt.getText().toString());
		
		// The code below allow us to perform specific conversion depending on radio button selected
		//Get id
		switch(view.getId()) {
		case R.id.radio0:
			// if radio button corresponding to Pound is clicked
			if (checked)
				// that means we need to convert from Kilograms to Pounds
				// kgToPounds method will be invoked 
				// and the value will be returned on the txt field
					txt.setText(kgToPounds(weight));
			break;
			
		case R.id.radio1:
			// if radio button corresponding to Kilograms is clicked
			if (checked)
				// that means we need to convert from Pounds to Kilograms
				// poundsToKg method will be invoked 
				// and the value will be returned on the txt field
					txt.setText(poundsToKg(weight));
			break;	
			
		}
		
	}
}
