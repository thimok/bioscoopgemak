//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;

public class AboutActivity extends MenuActivity {

	//================================================================================
	// Accessors
	//================================================================================
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("About");
        super.onCreateDrawer(toolbar,this);

        ConstraintLayout bioscoop = (ConstraintLayout) findViewById(R.id.activityAbout_BTN_bios);
        bioscoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BioscoopActivity.class);
                startActivity(i);
            }
        });
        ConstraintLayout app = (ConstraintLayout) findViewById(R.id.activityAbout_BTN_app);
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AppActivity.class);
                startActivity(i);
            }
        });
    }

}
