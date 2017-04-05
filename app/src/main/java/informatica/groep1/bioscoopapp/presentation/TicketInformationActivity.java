//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;
import informatica.groep1.bioscoopapp.presentation.MenuActivity;
import informatica.groep1.bioscoopapp.util.QRGenerator;

public class TicketInformationActivity extends MenuActivity {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private String title;
	private String date;
	private String time;
	private double price;
	private int amount;
	
	private TextView titleTextView;
	private TextView dateTextView;
	private TextView timeTextView;
	private TextView amountTextView;
	private TextView priceTextView;
	private ImageView qrImageView;
	private TextView seatsTextView;
	
	private static final String PRICE_PREFIX = "€ ";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ticket_information);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		super.onCreateDrawer(toolbar, this);
		
		Bundle extras = getIntent().getExtras();
		Ticket ticket = (Ticket) extras.getSerializable("ticket");
		
		title = ticket.getScreening().getTitle();
		date = ticket.getScreening().getPlayDate();
		time = ticket.getScreening().getStartTime();
		price = ticket.getPrice();
		amount = ticket.getSeats().size();
		
		titleTextView = (TextView) findViewById(R.id.ticketInformationActivity_TV_title);
		dateTextView = (TextView) findViewById(R.id.ticketInformationActivity_TV_showDate);
		timeTextView = (TextView) findViewById(R.id.ticketInformationActivity_TV_time);
		amountTextView = (TextView) findViewById(R.id.ticketInformationActivity_TV_amount);
		priceTextView = (TextView) findViewById(R.id.ticketInformationActivity_TV_price);
		qrImageView = (ImageView) findViewById(R.id.ticketInformationActivity_IV_qrCode);
		seatsTextView = (TextView) findViewById(R.id.ticketInformationActivity_TV_seatInformation); 
		
		titleTextView.setText(title);
		dateTextView.setText(date);
		timeTextView.setText(time);
		amountTextView.setText("" + amount);
		priceTextView.setText(PRICE_PREFIX + String.format("%.2f", price));
		qrImageView.setImageBitmap(QRGenerator.generate(title, date, time, ticket.getTicketID()));
		
		String seats;
		StringBuilder sb = new StringBuilder();
		
		for (Seat s : ticket.getSeats()) {
			sb.append("Seat " + s.getSeatID() + System.getProperty("line.separator"));
			sb.append(System.getProperty("line.separator"));
		}
		
		seats = sb.toString();
		
		seatsTextView.setText(seats);
	}
	
}
