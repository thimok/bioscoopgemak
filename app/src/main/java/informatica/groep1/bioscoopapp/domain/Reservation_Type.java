package informatica.groep1.bioscoopapp.domain;

//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

public class Reservation_Type {

    //================================================================================
    // Properties
    //================================================================================

    private int typeID;
    private String reservation_type;
    private double ticketPrice;

    //================================================================================
    // Constructors
    //================================================================================

    public  Reservation_Type( int typeID, String reservation_type, double ticketPrice) {
        this.reservation_type = reservation_type;
        this.typeID = typeID;
        this.ticketPrice = ticketPrice;
    }

    //================================================================================
    // Accessors
    //================================================================================


    public int getTypeID() {
        return typeID;
    }

    public String getReservation_type() {
        return reservation_type;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    //================================================================================
    // Mutators
    //================================================================================


    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setReservation_type(String reservation_type) {
        this.reservation_type = reservation_type;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
