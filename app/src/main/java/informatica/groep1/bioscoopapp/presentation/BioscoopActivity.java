//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;

public class BioscoopActivity extends MenuActivity {
	
	//================================================================================
	// Properties
	//================================================================================
	
    private ImageView bgIcon;
    private TextView biosInfo;

	//================================================================================
	// Accessors
	//================================================================================
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bioscoop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Biscoop Informatie");
        super.onCreateDrawer(toolbar,this);

        bgIcon = (ImageView) findViewById(R.id.activityBioscoop_IV_bgIcon);
        biosInfo = (TextView) findViewById(R.id.activityBioscoop_TV_biosInfo);


    }

}
