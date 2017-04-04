//================================================================================
// This class is made by:
// - Sven Westerlaken
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Screening;

public class ReservationActivity extends AppCompatActivity {

    private Screening screening;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        screening = (Screening) getIntent().getSerializableExtra("Screening");

        TextView title = (TextView) findViewById(R.id.reservationActivity_TV_movieTitle);
        TextView time = (TextView) findViewById(R.id.reservationActivity_TV_time);
        TextView date = (TextView) findViewById(R.id.reservationActivity_TV_date);

        title.setText(screening.getTitle());
        time.setText(screening.getStartTime());
        date.setText(screening.getPlayDate());
    }

}
