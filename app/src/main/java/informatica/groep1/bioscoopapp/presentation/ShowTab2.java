package informatica.groep1.bioscoopapp.presentation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.ShowListAdapter;
import informatica.groep1.bioscoopapp.data.ShowData;
import informatica.groep1.bioscoopapp.domain.ShowTitleRow;

/**
 * Created by lukab on 30-3-2017.
 */

public class ShowTab2 extends Fragment{

    private ListView showList, timeList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        View rootView = inflater.inflate( R.layout.tab_show2, container, false);

        showList = (ListView) rootView.findViewById(R.id.tomorrow_showlist);

        ShowData manager = new ShowData(getActivity());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        ArrayList<ShowTitleRow> screenings = manager.getShows( "= '" + dateFormat.format(calendar.getTime()) + "'");

        final ShowListAdapter showListAdapter = new ShowListAdapter(getActivity(), screenings, getActivity().getLayoutInflater());

        showList.setAdapter(showListAdapter);
        showListAdapter.notifyDataSetChanged();

        return rootView;
    }
}
