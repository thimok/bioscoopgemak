//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;

import java.io.Serializable;

public class Seat implements Serializable {
    //================================================================================
    // Properties
    //================================================================================
    public int seatID;
    public int row;
    public int number;
    public Auditorium auditorium;

    //================================================================================
    // Constructors
    //================================================================================

    public Seat(int seatID, int row, int number, Auditorium auditorium) {
        this.seatID = seatID;
        this.row = row;
        this.number = number;
        this.auditorium = auditorium;
    }
    //================================================================================
    // Accessors
    //================================================================================

    public int getSeatID() {
        return seatID;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    //================================================================================
    // Mutators
    //================================================================================

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
