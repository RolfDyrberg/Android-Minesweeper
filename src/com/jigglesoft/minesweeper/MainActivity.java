package com.jigglesoft.minesweeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private MinesweeperFragment minesweeperFragment;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
		minesweeperFragment = new MinesweeperFragment();
		getFragmentManager()
			.beginTransaction()
			.add(R.id.content_frame, minesweeperFragment)
			.commit();
		
	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		TextView remainingBombsTextView = (TextView) menu.findItem(R.id.action_bombs_remaining).getActionView();
		remainingBombsTextView.setText(String.valueOf(minesweeperFragment.remainingBombs()));
		
		return true;
	}
	
	
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    switch (item.getItemId()) {
	    
        case R.id.action_new_game:
    		minesweeperFragment.startNewGame();
            return true;
        
        case R.id.action_settings:
        	openSettings();
            return true;
        
        default:
            return super.onOptionsItemSelected(item);
	    }
	}
	
    
	private void openSettings() {
		Intent intent = new Intent(this, SettingsActivity.class);
		startActivity(intent);
	}

	
}
