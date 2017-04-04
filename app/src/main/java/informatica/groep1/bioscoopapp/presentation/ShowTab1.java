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

import java.util.List;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.ShowListAdapter;
import informatica.groep1.bioscoopapp.adapter.TimeListAdapter;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;

/**
 * Created by lukab on 30-3-2017.
 */

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

        DatabaseConnection showdatabase = new DatabaseConnection(getActivity());
       Cursor cursor = showdatabase.getShowNames("2017-04-03");

        final ShowListAdapter showListAdapter = new ShowListAdapter(getActivity(), cursor, false);

        showList.setAdapter(showListAdapter);
        showListAdapter.notifyDataSetChanged();



        return rootView;

   }



}
