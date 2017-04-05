//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

package informatica.groep1.bioscoopapp.data;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.ShowTitleRow;

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
        showtimes.moveToPosition(-1);

        while(shownames.moveToNext()){
            String title = shownames.getString(shownames.getColumnIndex("Title"));
            int ID = shownames.getInt(shownames.getColumnIndex("ScreeningID"));
            int movieID = shownames.getInt(shownames.getColumnIndex("MovieID"));

            ShowTitleRow titlerow = new ShowTitleRow(ID, title);
            screenings.add(titlerow);

            while (showtimes.moveToNext()) {
                int screeningMovieID = showtimes.getInt(showtimes.getColumnIndex("MovieID"));

                if(movieID == screeningMovieID) {
                    String screeningTitle = showtimes.getString(showtimes.getColumnIndex("Title"));
                    int screeningID = showtimes.getInt(showtimes.getColumnIndex("ScreeningID"));
                    String starttime = showtimes.getString(showtimes.getColumnIndex("StartTime"));
                    String endtime = showtimes.getString(showtimes.getColumnIndex("EndTime"));
                    String playdate = showtimes.getString(showtimes.getColumnIndex("Date"));
                    int movie3D = showtimes.getInt(showtimes.getColumnIndex("Film3D"));


                    Screening screening = new Screening(screeningID, movieID, screeningTitle, starttime, endtime, playdate, movie3D);
                    screenings.add(screening);
                }
            }

            showtimes.moveToPosition(-1);

        }

        shownames.close();
        showtimes.close();
        return screenings;
    }

}
