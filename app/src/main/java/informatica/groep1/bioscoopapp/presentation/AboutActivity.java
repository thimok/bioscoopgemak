package informatica.groep1.bioscoopapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;

public class AboutActivity extends MenuActivity {
    private ImageView biosIcon;
    private ImageView appIcon;
    private TextView bioscoop;
    private TextView app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("About");
        super.onCreateDrawer(toolbar,this);

        biosIcon = (ImageView) findViewById(R.id.activityAbout_IV_biosIcon);
        bioscoop = (TextView) findViewById(R.id.activityAbout_TV_Bioscoop);
        bioscoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BioscoopActivity.class);
                startActivity(i);
            }
        });
        appIcon = (ImageView) findViewById(R.id.activityAbout_IV_appIcon);
        app = (TextView) findViewById(R.id.activityAbout_TV_app);
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AppActivity.class);
                startActivity(i);
            }
        });




    }

}
