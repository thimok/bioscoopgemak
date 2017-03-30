package informatica.groep1.bioscoopapp.domain;

//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

public class Reservation {

    //================================================================================
    // Properties
    //================================================================================

    private int reservationID;
    private boolean paid;
    private  Screening screening;
    private Reservation_Type type;

    //================================================================================
    // Constructors
    //================================================================================

    public Reservation(int reservationID, boolean paid, Screening screening, Reservation_Type type) {
        this.reservationID = reservationID;
        this.paid = paid;
        this.screening = screening;
        this.type = type;
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

    public Reservation_Type getType() {
        return type;
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

    public void setType(Reservation_Type type) {
        this.type = type;
    }
}
