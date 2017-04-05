package informatica.groep1.bioscoopapp.businesslogic;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Seat;

/**
 * Created by Sven on 5-4-2017.
 */

public class SeatHandler {
    private ArrayList<Seat> seatsSelected;
    private TextView seatsremaining;
    private Button orderBtn;
    private int ticketCount;
    private GridView seatgrid;

    public SeatHandler(TextView seatsremaining, Button orderBtn, int ticketCount) {
        this.seatsSelected = new ArrayList<>();
        this.seatsremaining = seatsremaining;
        this.orderBtn = orderBtn;
        this.ticketCount = ticketCount;
        seatsremaining.setText("" + getRemainingCount());
        enableButton();
    }

    public void setGrid(GridView seatgrid) {
        this.seatgrid = seatgrid;
    }

    public void addSelectedSeat(Seat seat) {
        if(getRemainingCount() != 0) {
            seatsSelected.add(seat);
        }
    }

    public void removeSelectedSeat(Seat ss) {
        Iterator<Seat> i = seatsSelected.iterator();
        while (i.hasNext()) {
            Seat seat = i.next();
            if (seat.getSeatID() == ss.getSeatID()) {
                i.remove();
            }
        }
    }

    public int getRemainingCount() {
        return ticketCount - seatsSelected.size();
    }

    public void updateRemaining() {
        seatsremaining.setText("" + getRemainingCount());
    }

    public void enableButton() {
        if (ticketCount == seatsSelected.size()) {
            orderBtn.setEnabled(true);
        } else {
            orderBtn.setEnabled(false);
        }
    }

    public ArrayList<Seat> getSelectedSeats() {
        return seatsSelected;
    }




}
