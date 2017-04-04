package informatica.groep1.bioscoopapp.data;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.ShowTitleRow;

/**
 * Created by lukab on 4-4-2017.
 */

public class ShowData {
    private ArrayList<ShowTitleRow> screenings;
    private Context context;

    public ShowData(Context context){
        screenings = new ArrayList<>();
        this.context = context;
    }

    public ArrayList<ShowTitleRow> getShows(String date) {
        DatabaseConnection showdatabase = new DatabaseConnection(context);
        Cursor shownames = showdatabase.getShowNames(date);
        Cursor showtimes = showdatabase.getShowTimes(date);

        shownames.moveToPosition(-1);

        while(shownames.moveToNext()){
            String title = shownames.getString(shownames.getColumnIndex("Title"));
            int ID = shownames.getInt(shownames.getColumnIndex("ScreeningID"));

            ShowTitleRow titlerow = new ShowTitleRow(ID, title);
            screenings.add(titlerow);

            showtimes.moveToPosition(-1);

            while (showtimes.moveToNext()) {
                int screeningID = showtimes.getInt(showtimes.getColumnIndex("ScreeningID"));

                if(screeningID == ID) {
                    String screeningTitle = showtimes.getString(showtimes.getColumnIndex("Title"));
                    int movieID = showtimes.getInt(showtimes.getColumnIndex("MovieID"));
                    String starttime = showtimes.getString(showtimes.getColumnIndex("StartTime"));
                    String endtime = showtimes.getString(showtimes.getColumnIndex("EndTime"));
                    String playdate = showtimes.getString(showtimes.getColumnIndex("Date"));
                    int movie3D = showtimes.getInt(showtimes.getColumnIndex("Film3D"));


                    Screening screening = new Screening(screeningID, movieID, screeningTitle, starttime, endtime, playdate, movie3D);
                    screenings.add(screening);
                }
            }

        }

        shownames.close();
        showtimes.close();
        return screenings;
    }

}
