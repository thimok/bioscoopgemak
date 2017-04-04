package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.presentation.MovieDetailed;

import static java.security.AccessController.getContext;

/**
 * Created by lukab on 2-4-2017.
 */

public class ShowListAdapter extends CursorAdapter {

    public ShowListAdapter(Context context, Cursor cursor, boolean autoRequery) {

        super(context, cursor, 0);

    }

    @Override
    public  View newView(Context context, Cursor cursor, ViewGroup parent){

      View view = LayoutInflater.from(context).inflate(R.layout.row_show_list, parent, false);
       // ListView timeList = (ListView) view.findViewById(R.id.timeList);
     //   DatabaseConnection showdatabase = new DatabaseConnection(context);
      //  Cursor cursor2 = showdatabase.getShowTimes();
//
  //      final TimeListAdapter timeListAdapter = new TimeListAdapter( context, cursor2, false);
//
  //      timeList.setAdapter(timeListAdapter);
    //    timeListAdapter.notifyDataSetChanged();

        return view;


    }


    @Override
    public  void bindView(View view, Context context, Cursor cursor) {

        TextView nameMovie = (TextView) view.findViewById(R.id.movieShowText);


        String name = cursor.getString(cursor.getColumnIndex("Title"));

        nameMovie.setText(name);


    }



}

