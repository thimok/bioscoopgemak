package informatica.groep1.bioscoopapp.businesslogic;

import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Sven on 5-4-2017.
 */

public class TicketHandler {
    private int tickets, adultTickets, childrenTickets;
    private TextView ticketCount, adultTicketCount, childrenTicketCount, priceCount;
    private Button seatReservationBtn;

    public TicketHandler(TextView ticketCount, TextView adultTicketCount, TextView childrenTicketCount, TextView price, Button btn) {
        this.ticketCount = ticketCount;
        this.adultTicketCount = adultTicketCount;
        this.childrenTicketCount = childrenTicketCount;
        this.priceCount = price;
        this.seatReservationBtn = btn;
        enableButton();
    }

    public void enableButton() {
        if(tickets <= 0) {
            seatReservationBtn.setEnabled(false);
        } else {
            seatReservationBtn.setEnabled(true);
        }
    }

    public void addTicket() {
        if(tickets < 100) {
            this.tickets += 1;

            ticketCount.setText("" + tickets);

            if(adultTickets <= childrenTickets) {
                adultTickets += 1;
                adultTicketCount.setText("" + adultTickets);
            } else if (adultTickets > childrenTickets) {
                childrenTickets += 1;
                childrenTicketCount.setText("" + childrenTickets);
            }
        }
    }

    public void removeTicket() {
        if(tickets != 0) {
            this.tickets -= 1;

            ticketCount.setText("" + tickets);

            if(adultTickets <= childrenTickets) {
                childrenTickets -= 1;
                childrenTicketCount.setText("" + childrenTickets);
            } else if (adultTickets > childrenTickets){
                adultTickets -= 1;
                adultTicketCount.setText("" + adultTickets);
            }

        }

    }

    public void addAdultTicket() {
        if(adultTickets < tickets) {
            this.adultTickets += 1;

            while (adultTickets + childrenTickets != tickets && childrenTickets >= 0) {
                childrenTickets -= 1;
                childrenTicketCount.setText("" + childrenTickets);
                adultTicketCount.setText("" + adultTickets);
            }
        }
    }

    public void removeAdultTicket() {
        if(adultTickets != 0) {
            this.adultTickets -= 1;

            while (adultTickets + childrenTickets != tickets && childrenTickets >= 0) {
                childrenTickets += 1;
                childrenTicketCount.setText("" + childrenTickets);
                adultTicketCount.setText("" + adultTickets);
            }
        }

    }

    public void addChildrenTicket() {
        if(childrenTickets < tickets) {
            this.childrenTickets += 1;

            while (adultTickets + childrenTickets != tickets && adultTickets >= 0) {
                adultTickets -= 1;
                childrenTicketCount.setText("" + childrenTickets);
                adultTicketCount.setText("" + adultTickets);
            }
        }


    }

    public void removeChildrenTicket() {
        if(childrenTickets != 0) {
            this.childrenTickets -= 1;

            while (adultTickets + childrenTickets != tickets && adultTickets >= 0) {
                adultTickets += 1;
                childrenTicketCount.setText("" + childrenTickets);
                adultTicketCount.setText("" + adultTickets);
            }
        }

    }

    public int getTicketCount() {
        return tickets;
    }

    public double getPrice() {
        return adultTickets * 8 + childrenTickets * 6;
    }

    public void setPrice() {
        priceCount.setText("€" + String.format(Locale.GERMANY, "%.2f", getPrice()));
    }
}
