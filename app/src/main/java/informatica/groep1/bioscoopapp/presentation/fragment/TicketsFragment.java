//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.TicketListAdapter;
import informatica.groep1.bioscoopapp.businesslogic.TicketManager;
import informatica.groep1.bioscoopapp.domain.Auditorium;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Reservation;
import informatica.groep1.bioscoopapp.domain.Reservation_Type;
import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;

public class TicketsFragment extends Fragment {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private TicketManager ticketManager;
	
	private ListView ticketListView;
	private ArrayAdapter arrayAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_account_tickets, container, false);
		
		ticketManager = new TicketManager();
		
		ticketManager.demo();
		
		arrayAdapter = new TicketListAdapter(getActivity(), ticketManager.getTickets());
		
		ticketListView = (ListView) rootView.findViewById(R.id.ticketFragment_LV_list);
		ticketListView.setAdapter(arrayAdapter);
		ticketListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.i("Ticket Fragment", "Click: " + position);
				//TODO Intent toevoegen
			}
		});
		
		return rootView;
	}
}
