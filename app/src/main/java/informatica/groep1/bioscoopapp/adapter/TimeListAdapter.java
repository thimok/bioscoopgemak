package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import informatica.groep1.bioscoopapp.R;

/**
 * Created by lukab on 3-4-2017.
 */

public class TimeListAdapter extends CursorAdapter {


    public TimeListAdapter(Context context, Cursor cursor, boolean autoRequery) {

        super(context, cursor, 0);

    }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent){

        View view = LayoutInflater.from(context).inflate(R.layout.row_time_list, parent, false);
        return view;


    }


        @Override
        public  void bindView(View view, Context context, Cursor cursor) {

        TextView timeMovie = (TextView) view.findViewById(R.id.time_show);

        String time = cursor.getString(cursor.getColumnIndex("StartTime"));


        timeMovie.setText(time);

            String movieID = cursor.getString(cursor.getColumnIndex("MovieID"));

    }


    }
