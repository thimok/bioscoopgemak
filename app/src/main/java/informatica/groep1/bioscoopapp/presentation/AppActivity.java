//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;

public class AppActivity extends MenuActivity {
	
	//================================================================================
	// Properties
	//================================================================================
	
    private TextView credit,twan, sven, luka, thimo, devon;
    private ImageView teamGemak;

	//================================================================================
	// Accessors
	//================================================================================
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Who gets the Credits??");
        super.onCreateDrawer(toolbar,this);

        teamGemak = (ImageView) findViewById(R.id.activityApp_IV_teamGemak);
        credit =(TextView) findViewById(R.id.activityApp_TV_credit);
        twan =(TextView) findViewById(R.id.activityApp_TV_Twan);
        sven =(TextView) findViewById(R.id.activityApp_TV_Sven);
        luka =(TextView) findViewById(R.id.activityApp_TV_Luka);
        thimo =(TextView) findViewById(R.id.activityApp_TV_Thimo);
        devon =(TextView) findViewById(R.id.activityApp_TV_Devon);

    }

}
