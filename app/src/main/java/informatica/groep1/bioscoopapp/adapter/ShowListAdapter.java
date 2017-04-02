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
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.presentation.MovieDetailed;

/**
 * Created by lukab on 2-4-2017.
 */

public class ShowListAdapter extends CursorAdapter {

    public ShowListAdapter(Context context, Cursor cursor) {

        super(context, cursor, 0);

    }

    @Override
    public  View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.row_show_list, parent, false);

    }


    @Override
    public  void bindView(View view, Context context, Cursor cursor) {

        TextView nameMovie = (TextView) view.findViewById(R.id.movieShowText);

        String name = cursor.getString(cursor.getColumnIndex("name"));

        nameMovie.setText(name);
    }



}

