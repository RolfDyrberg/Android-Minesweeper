package com.jigglesoft.minesweeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		getFragmentManager().beginTransaction()
			.replace(R.id.settings_fragment_frame, new SettingsFragment())
			.commit();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

}
