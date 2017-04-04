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
import android.view.View;
import android.widget.Button;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Screening;

public class ShowDetailedActivity extends AppCompatActivity {

    private Screening screening;
    private FilmManager fManager;
    private View thisView;
    private Button mInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        thisView = this.findViewById(android.R.id.content);
        screening = (Screening) getIntent().getSerializableExtra("Screening");

        fManager = new FilmManager(thisView, this);
        fManager.findShowDetails("" + screening.getMovieID());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.showDetailedActivity_FAB_buyTickets);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mInfoBtn = (Button) findViewById(R.id.showDetailedActivity_BTN_moreInfo);
        mInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(getApplicationContext(), MovieDetailed.class);
                i.putExtra("MOVIE", movie);*/ // hier moet een movie object meegegeven worden met een calback
            }
        });


    }
}
