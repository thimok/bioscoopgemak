//================================================================================
// This class is made by:
// - Sven Westerlaken
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.devspark.robototextview.widget.RobotoButton;
import com.devspark.robototextview.widget.RobotoEditText;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.util.AlertCreator;
import informatica.groep1.bioscoopapp.util.ButtonDefine;

public class LoginActivity extends AppCompatActivity {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private EditText username, password;
	private Button submitButton;

	//================================================================================
	// Mutators
	//================================================================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		username = (RobotoEditText) findViewById(R.id.activityLogin_et_usernameInput);
		password = (RobotoEditText) findViewById(R.id.activityLogin_et_passwordInput);
		submitButton = (RobotoButton) findViewById(R.id.activityLogin_btn_login);
		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), ShowActivity.class);
				startActivity(i);
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		AlertCreator creator = new AlertCreator(this, "Exit", android.R.drawable.ic_dialog_alert, "Are you sure you want to exit?");
		creator.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.gc();
				System.exit(0);
			}
		});
		creator.setNegativeButton("No", null);
		creator.show();
	}
}
