//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.ShowListAdapter;
import informatica.groep1.bioscoopapp.adapter.TimeListAdapter;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.data.ShowData;
import informatica.groep1.bioscoopapp.domain.ShowTitleRow;

public class ShowTab1 extends Fragment {

    private ListView showList, timeList;
    private ShowListAdapter airportCursorAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


    View rootView = inflater.inflate( R.layout.tab_show1, container, false);

        showList = (ListView) rootView.findViewById(R.id.day_showlist);

        ShowData manager = new ShowData(getActivity());

        ArrayList<ShowTitleRow> screenings = manager.getShows();

        final ShowListAdapter showListAdapter = new ShowListAdapter(getActivity(), screenings, getActivity().getLayoutInflater());

        showList.setAdapter(showListAdapter);
        showListAdapter.notifyDataSetChanged();

        return rootView;

   }



}
