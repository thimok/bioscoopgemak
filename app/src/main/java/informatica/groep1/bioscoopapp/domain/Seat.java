//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;

import java.io.Serializable;

public class Seat implements Serializable {
    public int seatID;

    public Seat(int seatID) {
        this.seatID = seatID;
    }
    //================================================================================
    // Accessors
    //================================================================================

    public int getSeatID() {
        return seatID;
    }

    //================================================================================
    // Mutators
    //================================================================================

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }
}
