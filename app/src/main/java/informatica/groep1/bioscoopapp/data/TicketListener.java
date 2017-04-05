package informatica.groep1.bioscoopapp.data;

import informatica.groep1.bioscoopapp.domain.Ticket;

public interface TicketListener {
	
	void ticketAvailable(Ticket ticket);
}
