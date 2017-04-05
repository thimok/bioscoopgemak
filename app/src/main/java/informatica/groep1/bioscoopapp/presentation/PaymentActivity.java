//================================================================================
// This class is made by:
// - Sven Westerlaken
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Random;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{
    private Ticket ticket;
    private int childCount, adultCount;
    private DatabaseConnection dbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Screening screening = (Screening) getIntent().getSerializableExtra("Screening");
        ArrayList<Seat> reservedSeats = (ArrayList<Seat>) getIntent().getSerializableExtra("ReservedSeats");

        final double price = getIntent().getDoubleExtra("Price", 8.00);
	
	    Random random = new Random();
	    int range = 99999 - 2 + 1;
	    int ticketID = random.nextInt(range) + 1;
	
	    ticket = new Ticket(reservedSeats, ticketID, screening, price);
	    childCount = getIntent().getExtras().getInt("ChildCount");
	    adultCount = getIntent().getExtras().getInt("AdultCount");
        dbc = new DatabaseConnection(getApplicationContext());

        FrameLayout ideal = (FrameLayout) findViewById(R.id.paymentActivity_BTN_ideal);
        FrameLayout paypal = (FrameLayout) findViewById(R.id.paymentActivity_BTN_paypal);
        FrameLayout creditcard = (FrameLayout) findViewById(R.id.paymentActivity_BTN_creditcard);

        ideal.setOnClickListener(this);
        paypal.setOnClickListener(this);
        creditcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dbc.addTicketToDatabase(ticket, childCount, adultCount);
        Intent i = new Intent(getApplicationContext(), AccountActivity.class);
        startActivity(i);
    }
}
