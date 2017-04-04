//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;


import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable {
    //================================================================================
    // Properties
    //================================================================================
	
    private ArrayList<Seat> seats;
    private int ticketID;
    private Screening screening;
    private double price;
	private int amount;

    //================================================================================
    // Constructor
    //================================================================================

	
    public Ticket(ArrayList<Seat> seats, int ticketID, Screening screening, double price, int amount) {
        this.seats = seats;
        this.ticketID = ticketID;
        this.screening = screening;
	    this.price = price;
	    this.amount = amount;
    }

    //================================================================================
    // Accessors
    //================================================================================
	
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public int getTicketID() {
        return ticketID;
    }

    public Screening getScreening() {
        return screening;
    }
    
    public double getPrice() {
	    return price;
    }
    
    public int getAmount() {
	    return amount;
    }

    //================================================================================
    // Mutators
    //================================================================================
	
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
    
    public void setPrice(double price) {
	    this.price = price;
    }
    
    public void setAmount(int amount) {
	    this.amount = amount;
    }
}
