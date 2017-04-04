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

import informatica.groep1.bioscoopapp.R;
//import informatica.groep1.bioscoopapp.businesslogic.TicketManager;


public class TicketsFragment extends Fragment {

	//================================================================================
	// Properties
	//================================================================================

	//private TicketManager ticketManager;

	private ListView ticketListView;
	private ArrayAdapter arrayAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_account_tickets, container, false);

		//ticketManager = new TicketManager();

		//ticketManager.generate();

		//arrayAdapter = new TicketListAdapter(getActivity(), ticketManager.getTickets());

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
