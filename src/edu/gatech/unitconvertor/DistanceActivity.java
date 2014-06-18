package edu.gatech.unitconvertor;


import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DistanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	//Auto generate method
	super .onCreate(savedInstanceState);
	// Use setContentView to open the layout
	setContentView(R.layout.activity_distance);
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
	public String milesToKm(double miles) {
		double km = miles * 1.609;
		return String.valueOf(km);
	}
	
	public String kmToMiles(double km) {
		double miles = km / 1.609;
		return String.valueOf(miles);
	}
	// handleClick: this method is invoked from the layout activity_distance when either radio button is clicked
	public void handleClick(View view) {
		// Check the status of the radio button that is being clicked 
		boolean checked = ((RadioButton) view).isChecked();
		// Get reference for our text box and we use the id to get the reference
		// R is used to access the id and on that id the editText 1
		EditText txt = (EditText) findViewById(R.id.editText1);
		// convert txt to string and then parse to double
		double distance = Double.parseDouble(txt.getText().toString());
		
		// The code below allow us to perform specific conversion depending on radio button selected
		//Get id
		switch(view.getId()) {
		case R.id.radio0:
			// if radio button corresponding to miles is clicked
			if (checked)
				// that means we need to convert from km to Miles
				// kmToMiles method will be invoked to convert from Km to Miles
				// and the value will be returned on the txt field
					txt.setText(kmToMiles(distance));
			break;
			
		case R.id.radio1:
			// if radio button corresponding to miles is clicked
			if (checked)
				// that means we need to convert from Miles to Km
				// milesToKm method will be invoked to convert from miles to Km 
				// and the value will be returned and store on the txt field
					txt.setText(milesToKm(distance));
			break;	
			
		}
		
	}
	
}
