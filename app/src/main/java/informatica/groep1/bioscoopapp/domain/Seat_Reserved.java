//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;


public class Seat_Reserved {
    //================================================================================
    // Properties
    //================================================================================
    private Seat seat;
    private Reservation reservation;
    private int ticketID;
    private Screening screening;

    //================================================================================
    // Constructor
    //================================================================================

    public Seat_Reserved(Seat seat, Reservation reservation, int ticketID, Screening screening) {
        this.seat = seat;
        this.reservation = reservation;
        this.ticketID = ticketID;
        this.screening = screening;
    }

    //================================================================================
    // Accessors
    //================================================================================

    public Seat getSeat() {
        return seat;
    }

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

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

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
