package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class ShowTab3 extends Fragment {

   private ListView showList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {


        View rootView = inflater.inflate( R.layout.tab_show3, container, false);

        showList = (ListView) rootView.findViewById(R.id.week_showlist);

        ShowData manager = new ShowData(getActivity());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = "'" + dateFormat.format(calendar.getTime()) + "'";
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        String endOfWeek = "'" + dateFormat.format(calendar.getTime()) + "'";
        String datequery = "BETWEEN " + today + " AND " + endOfWeek;

        ArrayList<ShowTitleRow> screenings = manager.getShows( datequery);

        final ShowListAdapter showListAdapter = new ShowListAdapter(getActivity(), screenings, getActivity().getLayoutInflater());

        showList.setAdapter(showListAdapter);
        showListAdapter.notifyDataSetChanged();

        return rootView;

    }
}
