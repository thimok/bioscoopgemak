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

public class ShowListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ShowTitleRow> screenings;
    private LayoutInflater inflater;


    public ShowListAdapter(Context context, ArrayList<ShowTitleRow> screenings, LayoutInflater inflater) {
        this.context = context;
        this.screenings = screenings;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {
        return screenings.size();
    }

    @Override
    public Object getItem(int i) {
        return screenings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Class classname = screenings.get(i).getClass();



        if(classname.equals(ShowTitleRow.class)) {
            ShowTitleRow screening = screenings.get(i);
            view = inflater.inflate(R.layout.row_show_list, null);

            TextView nameMovie = (TextView) view.findViewById(R.id.movieShowText);

            nameMovie.setText(screening.getTitle());
            view.setClickable(false);

        } else if (classname.equals(Screening.class)) {
            final Screening screening = (Screening) screenings.get(i);
            view = inflater.inflate(R.layout.row_time_list, null);

            TextView timeMovie = (TextView) view.findViewById(R.id.time_show);

            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(Calendar.DAY_OF_MONTH, 1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String playDate = "";


            if (screening.getPlayDate().equals(dateFormat.format(calendar.getTime()))|| screening.getPlayDate().equals(dateFormat.format(calendar2.getTime()))){
                playDate =  "";

            }
            else if(!(screening.getPlayDate().equals(dateFormat.format(calendar.getTime()))|| screening.getPlayDate().equals(dateFormat.format(calendar2.getTime())))) {
                TextView textDate = (TextView) view.findViewById(R.id.date_show);
                textDate.setVisibility(View.VISIBLE);
                playDate = screening.getPlayDate();
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

