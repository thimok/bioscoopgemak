//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.HistoryImageAdapter;

public class HistoryFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_account_history, container, false);
		
		GridView gridView = (GridView) rootView.findViewById(R.id.historyFragment_GV_grid);
		if (gridView != null) {
			gridView.setAdapter(new HistoryImageAdapter(getActivity()));
		}
		
		return rootView;
	}
}
