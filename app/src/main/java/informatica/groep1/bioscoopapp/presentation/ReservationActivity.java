//================================================================================
// This class is made by:
// - Sven Westerlaken
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
import android.widget.FrameLayout;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoButton;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.businesslogic.TicketHandler;
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

        TextView ticketCount = (TextView) findViewById(R.id.reservationActivity_TV_ticketCount);
        TextView adultTicketCount = (TextView) findViewById(R.id.reservationActivity_TV_ticketCountAdults);
        TextView childrenTicketCount = (TextView) findViewById(R.id.reservationActivity_TV_ticketCountChildren);
        TextView priceTag = (TextView) findViewById(R.id.reservationActivity_TV_price);

        Button seatReservation = (RobotoButton) findViewById(R.id.reservationActivity_BTN_seatReservation);

        final TicketHandler tickethandler = new TicketHandler(ticketCount, adultTicketCount, childrenTicketCount, priceTag, seatReservation);

        FrameLayout ticketAdd = (FrameLayout) findViewById(R.id.reservationActivity_BTN_plus);
        FrameLayout ticketRemove = (FrameLayout) findViewById(R.id.reservationActivity_BTN_minus);
        FrameLayout ticketAdultAdd = (FrameLayout) findViewById(R.id.reservationActivity_BTN_plusAdults);
        FrameLayout ticketAdultRemove = (FrameLayout) findViewById(R.id.reservationActivity_BTN_minusAdults);
        FrameLayout ticketChildrenAdd = (FrameLayout) findViewById(R.id.reservationActivity_BTN_plusChildren);
        FrameLayout ticketChildrenRemove = (FrameLayout) findViewById(R.id.reservationActivity_BTN_minusChildren);

        seatReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SeatReservationActivity.class);
                i.putExtra("Screening", screening);
                i.putExtra("Price", tickethandler.getPrice());
                i.putExtra("TicketCount", tickethandler.getTicketCount());
                startActivity(i);
            }
        });

        ticketAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickethandler.addTicket();
                tickethandler.setPrice();
                tickethandler.enableButton();
            }
        });

        ticketRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickethandler.removeTicket();
                tickethandler.setPrice();
                tickethandler.enableButton();
            }
        });

        ticketAdultAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickethandler.addAdultTicket();
                tickethandler.setPrice();
                tickethandler.enableButton();
            }
        });

        ticketAdultRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickethandler.removeAdultTicket();
                tickethandler.setPrice();
                tickethandler.enableButton();
            }
        });

        ticketChildrenAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickethandler.addChildrenTicket();
                tickethandler.setPrice();
                tickethandler.enableButton();
            }
        });

        ticketChildrenRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickethandler.removeChildrenTicket();
                tickethandler.setPrice();
                tickethandler.enableButton();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 'home' is the id for the icon click in the action bar (i.e. up/back).
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
