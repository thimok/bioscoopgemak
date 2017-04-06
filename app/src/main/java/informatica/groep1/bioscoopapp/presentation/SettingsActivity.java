//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;

import static android.R.style.Theme_DeviceDefault_Dialog_Alert;

public class SettingsActivity extends MenuActivity {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private TextView languageSelected;
	private DatabaseConnection dbc;
	
	//================================================================================
	// Mutators
	//================================================================================
	
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
		String currentLanguage = dbc.getCurrentSelectedLanguage();
		
		languageSelected = (TextView) findViewById(R.id.settingsActivity_TV_languageSelected);
		ConstraintLayout languageOption = (ConstraintLayout) findViewById(R.id.settingsActivity_L_languageSetting);
		ConstraintLayout accountOption = (ConstraintLayout) findViewById(R.id.settingsActivity_L_accountSetting);

		languageOption.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeLanguage();
			}
		});
		accountOption.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeAccount();
			}
		});

		languageSelected.setText(currentLanguage);
	}
	
	private void changeLanguage() {
		Log.i("Settings", "Language selected");
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this, Theme_DeviceDefault_Dialog_Alert);
		builder.setTitle(R.string.settings_language_choose);
		builder.setIcon(R.drawable.ic_language_white_24dp);
		builder.setItems(R.array.settings_language_array, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
					case 0:
						//English
						dbc.changeLanguage("English");
						setLanguage("en");
						break;
					
					case 1:
						//Dutch
						dbc.changeLanguage("Nederlands");
						setLanguage("nl");
						break;
				}
				
				languageSelected.setText(dbc.getCurrentSelectedLanguage());
			}
		});
		builder.show();
	}
	
	private void changeAccount() {
		Toast toast = Toast.makeText(getApplicationContext(), "Function not implemented", Toast.LENGTH_SHORT);
		toast.show();
	}

	public void setLanguage(String language) {
		String lang = language;
		
		Log.i("Settings", "Language changed:" + lang);
		
		Locale locale = new Locale(lang);
		Locale.setDefault(locale);
		Resources res = getResources();
		Configuration config = res.getConfiguration();
		config.setLocale(locale);
		getApplicationContext().createConfigurationContext(config);
		
		Intent i = new Intent(getApplicationContext(), MovieActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
}
