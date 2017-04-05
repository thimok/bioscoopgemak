//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Ticket;

public class TicketListAdapter extends ArrayAdapter<Ticket> {
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public TicketListAdapter(Context context, ArrayList<Ticket> tickets) {
		super(context, 0, tickets);
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	/**
	 * On the view (row), manipulate all contents such as TextViews to match the movie's details.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Ticket ticket = getItem(position);
		
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_ticket_list, parent, false);
		}
		
		TextView movieTitle = (TextView) convertView.findViewById(R.id.ticketFragment_TV_movieTitle);
		movieTitle.setText(ticket.getScreening().getTitle());
		
		TextView showDate = (TextView) convertView.findViewById(R.id.ticketFragment_TV_showDate);
		showDate.setText(ticket.getScreening().getPlayDate());
		
		TextView showTime = (TextView) convertView.findViewById(R.id.ticketFragment_TV_showTime);
		showTime.setText(ticket.getScreening().getStartTime());
		
		return convertView;
	}
}
