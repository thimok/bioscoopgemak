//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;


public class Ticket {
    //================================================================================
    // Properties
    //================================================================================
    private Reservation reservation;
    private int ticketID;
    private Screening screening;

    //================================================================================
    // Constructor
    //================================================================================

    public Ticket(Reservation reservation, int ticketID, Screening screening) {
        this.reservation = reservation;
        this.ticketID = ticketID;
        this.screening = screening;
    }

    //================================================================================
    // Accessors
    //================================================================================

    public Reservation getReservation() {
        return reservation;
    }

    public int getTicketID() {
        return ticketID;
    }

    public Screening getScreening() {
        return screening;
    }

    //================================================================================
    // Mutators
    //================================================================================

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
}
