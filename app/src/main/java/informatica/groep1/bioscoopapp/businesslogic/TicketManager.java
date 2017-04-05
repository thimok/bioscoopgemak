//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.businesslogic;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.domain.Auditorium;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Reservation;
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
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	public void generate() {
		demo();
	}
	public void demo() {
		Movie m1 = new Movie(1, "Test", "8.9", "2017");
		Movie m2 = new Movie(1, "Demo", "9.1", "2016");
		
		Auditorium a1 = new Auditorium(1, 10, 10);
		
		Screening s1 = new Screening(1, "11:30", "13:30", "03-04-2017", a1, m1, false);
		Screening s2 = new Screening(2, "14:00", "16:00", "03-04-2017", a1, m2, false);
		Screening s3 = new Screening(3, "16:30", "18:30", "03-04-2017", a1, m2, false);
		Screening s4 = new Screening(4, "17:00", "19:00", "03-04-2017", a1, m1, false);
		Screening s5 = new Screening(5, "19:30", "21:30", "03-04-2017", a1, m1, false);
		
		Seat seat1 = new Seat(1, 1, 1, a1);
		Seat seat2 = new Seat(2, 1, 2, a1);
		Seat seat3 = new Seat(3, 1, 3, a1);
		Seat seat4 = new Seat(4, 1, 4, a1);
		
		Reservation r1 = new Reservation(1, true, s1);
		Reservation r2 = new Reservation(2, true, s2);
		Reservation r3 = new Reservation(3, true, s3);
		Reservation r4 = new Reservation(4, true, s4);
		Reservation r5 = new Reservation(5, true, s5);
		
		ArrayList<Seat> as1 = new ArrayList<>();
		as1.add(seat1);
		as1.add(seat2);
		
		ArrayList<Seat> as2 = new ArrayList<>();
		as2.add(seat2);
		as2.add(seat3);
		as2.add(seat4);
		
		Ticket t1 = new Ticket(as1, 1, s1, 28.00D, 4);
		Ticket t2 = new Ticket(as2, 2, s2, 20.50D, 3);
		Ticket t3 = new Ticket(as2, 3, s3, 28.00D, 4);
		Ticket t4 = new Ticket(as1, 4, s4, 14.00D, 2);
		Ticket t5 = new Ticket(as2, 5, s5, 33.50D, 5);
		
		tickets.clear();
		
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		tickets.add(t5);
	}
	
}
