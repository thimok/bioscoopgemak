package informatica.groep1.bioscoopapp.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.util.Language;

public class SettingsActivity extends MenuActivity implements Language.LocaleChangeListener {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private TextView languageSelected;
	private TextView languageChoose;
	private ImageView languageIcon;
	
	private TextView accountText;
	private ImageView accountIcon;
	
	private DatabaseConnection dbc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setTitle("Settings");
		super.onCreateDrawer(toolbar, this);
		
		dbc = new DatabaseConnection(getApplicationContext());
		
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
		
		String currentLanguage = dbc.getCurrentSelectedLanguage();
		
		languageSelected.setText(currentLanguage);
		
		Language.addListener(this);
	}
	
	private void changeLanguage() {
		Log.i("Settings", "Language selected");
		
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle(R.string.settings_language_choose);
		builder.setItems(R.array.settings_language_array, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
					case 0:
						//English
						dbc.changeLanguage("English");
						Language.setLocale("eng");
						break;
					
					case 1:
						//Dutch
						dbc.changeLanguage("Nederlands");
						Language.setLocale("nl");
						break;
				}
				
				languageSelected.setText(dbc.getCurrentSelectedLanguage());
			}
		});
		builder.show();
	}
	
	private void changeAccount() {
		Log.i("Settings", "Account selected");
	}
	
	@Override
	public void onLocaleChanged(Locale locale) {
		Log.i("Settings", "Language changed.");
//		Intent i = getIntent();
//		i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//		finish();
//		startActivity(i);
		recreate();
	}
}
