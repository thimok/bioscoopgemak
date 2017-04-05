package informatica.groep1.bioscoopapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.Seat;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Screening screening = (Screening) getIntent().getSerializableExtra("Screening");
        ArrayList<Seat> reservedSeats = (ArrayList<Seat>) getIntent().getSerializableExtra("ReservedSeats");
        int ticketCount = reservedSeats.size();
        final double price = getIntent().getDoubleExtra("Price", 8.00);
    }

}
