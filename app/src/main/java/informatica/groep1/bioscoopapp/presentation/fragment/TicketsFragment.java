//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.TicketListAdapter;
import informatica.groep1.bioscoopapp.businesslogic.TicketManager;
import informatica.groep1.bioscoopapp.data.TicketListener;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;
import informatica.groep1.bioscoopapp.presentation.TicketInformationActivity;

public class TicketsFragment extends Fragment implements TicketListener {

	//================================================================================
	// Properties
	//================================================================================

	private TicketManager ticketManager;

	private ListView ticketListView;
	private ArrayAdapter arrayAdapter;
	
	//================================================================================
	// Accessors
	//================================================================================
	
	/**
	 * Overridden method called when the view is created
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_account_tickets, container, false);

		ticketManager = new TicketManager();

		arrayAdapter = new TicketListAdapter(getActivity(), ticketManager.getTickets());

		ticketListView = (ListView) rootView.findViewById(R.id.ticketFragment_LV_list);
		ticketListView.setAdapter(arrayAdapter);
		ticketListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.i("Ticket Fragment", "Click: " + position);
				Ticket ticket = ticketManager.getTickets().get(position);
				
				Intent i = new Intent(getActivity(), TicketInformationActivity.class);
				i.putExtra("ticket", ticket);
				startActivity(i);
			}
		});
		
		ticketManager.loadTickets(getContext(), this);

		return rootView;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	/**
	 * Interface method called when a ticket instance is available
	 * @param ticket ticket instance
	 */
	@Override
	public void ticketAvailable(Ticket ticket) {
		Log.i("Ticket available", "Amount: " + ticket.getSeats().size());
		for (Seat seat : ticket.getSeats()) {
			Log.i("Ticket data " + ticket.getTicketID(), "Seat " + seat.getSeatID());
		}
		ticketManager.add(ticket);
		arrayAdapter.notifyDataSetChanged();
	}
}
