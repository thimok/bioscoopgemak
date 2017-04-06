//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.ShowTitleRow;
import informatica.groep1.bioscoopapp.presentation.MovieDetailed;
import informatica.groep1.bioscoopapp.presentation.ShowDetailedActivity;

import static java.security.AccessController.getContext;

/**
 * PagerAdapter.java - A adapter class that extends the BaseAdapter superclass.
 * @Author Sven Westerlaken, Luka Brinkman
 * @version 1.0
 */

public class ShowListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ShowTitleRow> screenings;
    private LayoutInflater inflater;
    private boolean firstMovie = true;

    /**
     * The constructor.
     * @param context
     * @param screenings the arraylist of the ShowData.class
     * @param inflater
     */

    public ShowListAdapter(Context context, ArrayList<ShowTitleRow> screenings, LayoutInflater inflater) {
        this.context = context;
        this.screenings = screenings;
        this.inflater = inflater;
    }


    /**
     * Method that gets the size of the arraylist
     * @return an int value: the size of the arraylist
     */
    @Override
    public int getCount() {
        return screenings.size();
    }

    /**
     * Method that gets an item of the arraylist
     * @param i the position of the arraylist
     * @return an Object of the arraylist : a screening
     */
    @Override
    public Object getItem(int i) {
        return screenings.get(i);
    }


    /**
     * A method thats returns an ID
     * @param i the position
     * @return an int value
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * A method that returns a View and sets the textviews and other items.
     * @param i the position of the arraylist
     * @return a View that shows the screenings by using an arraylist
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Class classname = screenings.get(i).getClass();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        if(classname.equals(ShowTitleRow.class)) {
            ShowTitleRow screening = screenings.get(i);

            if(firstMovie) {
                view = inflater.inflate(R.layout.row_show_list, null);
                firstMovie = false;
            } else {
                view = inflater.inflate(R.layout.row_show_list_divider, null);
            }

            TextView nameMovie = (TextView) view.findViewById(R.id.movieShowText);

            nameMovie.setText(screening.getTitle());
            view.setClickable(false);

        } else if (classname.equals(Screening.class)) {
            final Screening screening = (Screening) screenings.get(i);
            view = inflater.inflate(R.layout.row_time_list, null);

            TextView timeMovie = (TextView) view.findViewById(R.id.time_show);

            if(!(screening.getPlayDate().equals(dateFormat.format(calendar.getTime()))|| screening.getPlayDate().equals(dateFormat.format(calendar2.getTime())))) {

                TextView textDate = (TextView) view.findViewById(R.id.date_show);
                ImageView dateIcon = (ImageView) view.findViewById(R.id.imageView8);
                textDate.setVisibility(View.VISIBLE);
                dateIcon.setVisibility(View.VISIBLE);
                String playDate = screening.getPlayDate();
                textDate.setText(playDate);
            }

            timeMovie.setText(screening.getStartTime());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, ShowDetailedActivity.class);
                    i.putExtra("Screening", screening);
                    context.startActivity(i);
                }
            });


        }

        return view;
    }
}

