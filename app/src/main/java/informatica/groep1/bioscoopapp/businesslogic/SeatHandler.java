package informatica.groep1.bioscoopapp.businesslogic;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.SeatGridAdapter;
import informatica.groep1.bioscoopapp.domain.Seat;

/**
 * Created by Sven on 5-4-2017.
 */

public class SeatHandler {
    private ArrayList<Seat> seatsSelected;
    private TextView seatsremaining;
    private Button orderBtn;
    private int ticketCount;
    private SeatGridAdapter adapter;

    public SeatHandler(TextView seatsremaining, Button orderBtn, int ticketCount) {
        this.seatsSelected = new ArrayList<>();
        this.seatsremaining = seatsremaining;
        this.orderBtn = orderBtn;
        this.ticketCount = ticketCount;
        seatsremaining.setText("" + getRemainingCount());
        enableButton();
    }

    public void setSeatgridAdapter(SeatGridAdapter adapter) {
        this.adapter = adapter;
    }

    public void addSelectedSeat(Seat seat, CheckBox checkbox) {
        if(getRemainingCount() > 1) {
            seatsSelected.add(seat);
            updateRemaining();
        } else {
            seatsSelected.add(seat);
            updateRemaining();
            enableButton();
            disableCheckBoxes(checkbox);
        }
    }

    public void disableCheckBoxes(CheckBox checkbox) {
        for(int i=0; i < adapter.getCheckboxes().size(); i++) {
            CheckBox loopingCheckBox = adapter.getCheckboxes().get(i);

            if(loopingCheckBox != checkbox) {
                loopingCheckBox.setEnabled(false);
            }
        }
    }

    public void enableCheckBoxes() {
        for(int i=0; i < adapter.getCheckboxes().size(); i++) {
            adapter.getCheckboxes().get(i).setEnabled(true);
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
        updateRemaining();
        enableButton();
        enableCheckBoxes();

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
