package informatica.groep1.bioscoopapp.presentation;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import informatica.groep1.bioscoopapp.R;

public class SplashScreenActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		new CountDownTimer(2000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				
			}
			
			@Override
			public void onFinish() {
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		}.start();
	}
}
