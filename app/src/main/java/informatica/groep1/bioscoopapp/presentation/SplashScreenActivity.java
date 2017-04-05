//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.util.LanguageManager;

public class SplashScreenActivity extends AppCompatActivity {
	
	//================================================================================
	// Mutators
	//================================================================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LanguageManager.setApplicationLocale(getApplicationContext(), LanguageManager.getLocale(getApplicationContext()));
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		new CountDownTimer(2000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				
			}
			
			@Override
			public void onFinish() {
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			}
		}.start();
	}
}
