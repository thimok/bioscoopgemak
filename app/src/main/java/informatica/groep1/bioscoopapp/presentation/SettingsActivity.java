package informatica.groep1.bioscoopapp.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import informatica.groep1.bioscoopapp.data.DatabaseConnection;

public class SettingsActivity extends MenuActivity {
	
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
	}
	
	private void changeLanguage() {
		Log.i("Settings", "Language selected");
		
		AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
		builder.setTitle(R.string.settings_language_choose_en);
		builder.setItems(R.array.settings_language_array_en, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
					case 0:
						//English
						dbc.changeLanguage("English");
						break;
					
					case 1:
						//Dutch
						dbc.changeLanguage("Nederlands");
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
}
