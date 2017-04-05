//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.Serializable;
import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.HistoryImageAdapter;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.HistoryFilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.presentation.MovieDetailed;

public class HistoryFragment extends Fragment implements MovieListener {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private HistoryFilmManager manager;
	private HistoryImageAdapter adapter;
	
	//================================================================================
	// Accessors
	//================================================================================
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_account_history, container, false);
		
		manager = new HistoryFilmManager(getContext(), this);
		
		manager.generate();
		
		GridView gridView = (GridView) rootView.findViewById(R.id.historyFragment_GV_grid);
		if (gridView != null) {
			adapter = new HistoryImageAdapter(getActivity(), manager.getMovies());
			gridView.setAdapter(adapter);
		}
		
		return rootView;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	@Override
	public void onMovieAvailable(Movie movie) {
		Log.i("History Movie Avail", movie.getTitle());
		
		manager.add(movie);
		adapter.notifyDataSetChanged();
	}
}
