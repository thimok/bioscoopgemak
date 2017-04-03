package informatica.groep1.bioscoopapp.businesslogic;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.domain.Auditorium;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Reservation;
import informatica.groep1.bioscoopapp.domain.Reservation_Type;
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
		
		Reservation_Type rt1 = new Reservation_Type(1, "Adult", 10.0d);
		
		Reservation r1 = new Reservation(1, true, s1, rt1);
		Reservation r2 = new Reservation(2, true, s2, rt1);
		Reservation r3 = new Reservation(3, true, s3, rt1);
		Reservation r4 = new Reservation(4, true, s4, rt1);
		Reservation r5 = new Reservation(5, true, s5, rt1);
		
		Ticket t1 = new Ticket(seat1, r1, 1, s1);
		Ticket t2 = new Ticket(seat2, r2, 1, s2);
		Ticket t3 = new Ticket(seat3, r3, 1, s3);
		Ticket t4 = new Ticket(seat4, r4, 1, s4);
		Ticket t5 = new Ticket(seat4, r5, 1, s5);
		
		tickets.clear();
		
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		tickets.add(t5);
	}
}
