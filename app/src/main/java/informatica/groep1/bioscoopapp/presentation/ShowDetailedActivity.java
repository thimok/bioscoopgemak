//================================================================================
// This class is made by:
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;

import org.w3c.dom.Text;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Screening;

public class ShowDetailedActivity extends AppCompatActivity implements MovieListener {

    //================================================================================
    // Properties
    //================================================================================
    
    private Screening screening;
    private FilmManager fManager;
    private View thisView;
    private Button mInfoBtn;
    private TextView sTime;
    private TextView sDate;
    private TextView sLanguage;
    private TextView sSubtitles;
    private TextView sAddons;
    private ImageView iAddons;
    private Movie movie;

	//================================================================================
	// Mutators
	//================================================================================
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        thisView = this.findViewById(android.R.id.content);
        screening = (Screening) getIntent().getSerializableExtra("Screening");

        sTime = (RobotoTextView) findViewById(R.id.showDetailedActivity_TV_time);
        sDate = (RobotoTextView) findViewById(R.id.showDetailedActivity_TV_playdate);
        sLanguage = (RobotoTextView) findViewById(R.id.showDetailedActivity_TV_language);
        sSubtitles = (RobotoTextView) findViewById(R.id.showDetailedActivity_TV_subtitles);
        sAddons = (RobotoTextView) findViewById(R.id.showDetailedActivity_TV_addons);
        iAddons = (ImageView) findViewById(R.id.showDetailedActivity_IV_addons);

        // Language and Subtitles
        sTime.setText(screening.getStartTime() + " - " + screening.getEndTime());
        sDate.setText(screening.getPlayDate());
        if (screening.getIs3D()) {
            sAddons.setText("3D");
        } else {
            sAddons.setText("None");
        }

        fManager = new FilmManager(thisView, this, this);
        fManager.findShowDetails("" + screening.getMovieID());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.showDetailedActivity_FAB_buyTickets);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ReservationActivity.class);
                i.putExtra("Screening", screening);
                startActivity(i);
            }
        });

        mInfoBtn = (Button) findViewById(R.id.showDetailedActivity_BTN_moreInfo);
    }
	
    @Override
    public void onMovieAvailable(Movie foundMovie) {
        movie = foundMovie;
        mInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click More Info", movie.getBackDropImage());
                Intent i = new Intent(getApplicationContext(), MovieDetailed.class);
                i.putExtra("Movie", movie);
                startActivity(i); // hier moet een movie object meegegeven worden met een calback
            }
        });
    }
}
