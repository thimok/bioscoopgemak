package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.businesslogic.SeatHandler;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;

/**
 * Created by Sven on 5-4-2017.
 */

public class SeatGridAdapter extends BaseAdapter {
    private ArrayList<Seat> seats;
    private Context context;
    private SeatHandler seathandler;

    public SeatGridAdapter(Context context, ArrayList<Seat> seats, SeatHandler seathandler) {
        this.context = context;
        this.seats = seats;
        this.seathandler = seathandler;
    }

    @Override
    public int getCount() {
        return seats.size();
    }

    @Override
    public Object getItem(int i) {
        return seats.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Seat seat = (Seat) getItem(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.seat_grid_item, null);
        }

        CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkBox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    seathandler.addSelectedSeat(seat);
                    seathandler.updateRemaining();
                    seathandler.enableButton();
                } else if (!b) {
                    seathandler.removeSelectedSeat(seat);
                    seathandler.updateRemaining();
                    seathandler.enableButton();
                }

            }
        });

        return view;
    }
}
