//================================================================================
// This class is made by:
// - Sven Westerlaken
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Screening screening = (Screening) getIntent().getSerializableExtra("Screening");
        ArrayList<Seat> reservedSeats = (ArrayList<Seat>) getIntent().getSerializableExtra("ReservedSeats");
        for (Seat seat : reservedSeats) {
	        Log.i("Seat reserved", "" + seat.getSeatID());
        }
        int ticketCount = reservedSeats.size();
        final double price = getIntent().getDoubleExtra("Price", 8.00);
	
	    Random random = new Random();
	    int range = 99999 - 2 + 1;
	    int ticketID = random.nextInt(range) + 1;
	
	    Ticket ticket = new Ticket(reservedSeats, ticketID, screening, price);
	    int childCount = getIntent().getExtras().getInt("ChildCount");
	    int adultCount = getIntent().getExtras().getInt("AdultCount");
	
	    DatabaseConnection dbc = new DatabaseConnection(getApplicationContext());
	    dbc.addTicketToDatabase(ticket, childCount, adultCount);
    }
}
