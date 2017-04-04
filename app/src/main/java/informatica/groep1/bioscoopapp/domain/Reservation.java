package informatica.groep1.bioscoopapp.domain;

//================================================================================
// This class is made by:
// - Luka Brinkman
// - Thimo Koolen
//================================================================================

public class Reservation {

    //================================================================================
    // Properties
    //================================================================================

    private int reservationID;
    private boolean paid;
    private Screening screening;

    //================================================================================
    // Constructors
    //================================================================================

    public Reservation(int reservationID, boolean paid, Screening screening) {
        this.reservationID = reservationID;
        this.paid = paid;
        this.screening = screening;
        }

    //================================================================================
    // Accessors
    //================================================================================


    public int getReservationID() {
        return reservationID;
    }

    public boolean isPaid() {
        return paid;
    }

    public Screening getScreening() {
        return screening;
    }

    //================================================================================
    // Mutators
    //================================================================================


    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
}
