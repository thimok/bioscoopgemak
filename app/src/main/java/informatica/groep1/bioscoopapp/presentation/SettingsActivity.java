package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;

public class SettingsActivity extends MenuActivity {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private TextView languageSelected;
	private TextView languageChoose;
	private ImageView languageIcon;
	
	private TextView accountText;
	private ImageView accountIcon;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setTitle("Settings");
		super.onCreateDrawer(toolbar, this);
		
		languageSelected = (TextView) findViewById(R.id.settingsActivity_TV_languageSelected);
		languageSelected.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeLanguage();
			}
		});
		
		languageChoose = (TextView) findViewById(R.id.settingsActivity_TV_languageText);
		languageChoose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeLanguage();
			}
		});
		
		languageIcon = (ImageView) findViewById(R.id.settingsActivity_IV_languageIcon);
		languageIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeLanguage();
			}
		});
		
		accountText = (TextView) findViewById(R.id.settingsActivity_TV_accountText);
		accountText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeAccount();
			}
		});
		
		accountIcon = (ImageView) findViewById(R.id.settingsActivity_IV_accountIcon);
		accountIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeAccount();
			}
		});
	}
	
	private void changeLanguage() {
		Log.i("Settings", "Language selected");
	}
	
	private void changeAccount() {
		Log.i("Settings", "Account selected");
	}
}
