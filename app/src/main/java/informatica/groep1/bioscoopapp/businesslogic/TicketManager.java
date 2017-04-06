//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.businesslogic;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.data.TicketListener;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;

public class TicketManager {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private ArrayList<Ticket> tickets;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public TicketManager() {
		tickets = new ArrayList<>();
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	/**
	 * Load tickets from arraylist
	 * @return list of tickets
	 */
	public ArrayList<Ticket> getTickets() {
		Log.i("TicketManager Return", "Called");
		for (Ticket t : tickets) {
			Log.i("TicketManager Return", "" + t.getSeats().size());
		}
		return tickets;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	/**
	 * Load tickets from database
	 * @param context Application context
	 * @param listener Callback listener class
	 */
	public void loadTickets(Context context, TicketListener listener) {
		DatabaseConnection dbc = new DatabaseConnection(context);
		dbc.getTickets(listener);
	}
	
	/**
	 * Add ticket to list
	 * @param ticket ticket instance
	 */
	public void add(Ticket ticket) {
		tickets.add(ticket);
		Log.i("TicketManager", "Amount: " + ticket.getSeats().size());
	}
	
	/**
	 * Old method to load demo data
	 * @deprecated old method
	 */
	@Deprecated
	public void demo() {
		Movie m1 = new Movie(1, "Beauty And The Beast", "7.1", "2017");
		Movie m2 = new Movie(1, "Sing", "6.7", "2016");

		Seat seat1 = new Seat(1);
		Seat seat2 = new Seat(2);
		Seat seat3 = new Seat(3);
		Seat seat4 = new Seat(4);

		Screening s6 = new Screening(1, 1, "Beauty And The Beast", "11:30", "13:45", "03-04-2017", 0);


		ArrayList<Seat> as1 = new ArrayList<>();
		as1.add(seat1);
		as1.add(seat2);
		
		ArrayList<Seat> as2 = new ArrayList<>();
		as2.add(seat2);
		as2.add(seat3);
		as2.add(seat4);
		
		Ticket t1 = new Ticket(as1, 1, s6, 16.00D);
		Ticket t2 = new Ticket(as2, 2, s6, 24.00D);
		Ticket t3 = new Ticket(as2, 3, s6, 28.00D);
		Ticket t4 = new Ticket(as1, 4, s6, 14.00D);
		Ticket t5 = new Ticket(as2, 5, s6, 22.00D);
		
		tickets.clear();
		
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		tickets.add(t5);
	}
	
}
