package edu.gatech.unitconvertor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
//import android.widget.EditText;
//import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	}
	
	public void gotoDistanceActivity(View view) {
				
		Intent intent = new Intent(this, DistanceActivity.class);
		startActivity(intent);
		
	}
	
	public void gotoTempActivity(View view) {
		
		Intent intent = new Intent(this, TemperatureActivity.class);
		startActivity(intent);

    }
	
	public void gotoWeightActivity(View view) {
		
		Intent intent = new Intent(this, WeightActivity.class);
		startActivity(intent);

    }
}
