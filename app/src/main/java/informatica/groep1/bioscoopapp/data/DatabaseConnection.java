//================================================================================
// This class is made by:
// - Luka Brinkman
// - Thimo Koolen
//================================================================================


package informatica.groep1.bioscoopapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.Date;

import informatica.groep1.bioscoopapp.api.MovieDBAPIConnector;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Screening;
import informatica.groep1.bioscoopapp.domain.Seat;
import informatica.groep1.bioscoopapp.domain.Ticket;

/**
 * DatabaseConnection.java - a class that extens the SQLLiteAssetHelper superclass.
 * @Author Thimo Koolen, Luka Brinkman
 * @version 1.0
 */

public class DatabaseConnection extends SQLiteAssetHelper {
	
	//================================================================================
	// Properties
	//================================================================================
	
    private static final String DATABASE_NAME = "SQL.sqlite";
    private static final int DATABASE_VERSION = 2;

	//================================================================================
	// Constructors
	//================================================================================
	
    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


	/**
	 * A method that uses a String to write a query and eventually returns a cursor. To get the show names.
	 * @param date the date of today, tomorrow or the rest of the week (depends on which tab is selected)
	 * @return data of the Screening table (Cursor)
	 */

    public Cursor getShowNames(String date) {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT Title, MovieID, ScreeningID FROM Screening WHERE Date " + date +  " GROUP BY Title ORDER BY Title";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        db.close();
        return c;
    }

	/**
	 * A method that uses a String to write a query and eventually returns a cursor. To get the show times.
	 * @param date the date of today, tomorrow or the rest of the week (depends on which tab is selected)
	 * @return data of the Screening table (Cursor)
	 */
    public Cursor getShowTimes(String date) {

		SQLiteDatabase db = getReadableDatabase();

		String query = "SELECT Title, StartTime, EndTime, MovieID, ScreeningID, Film3D, Date FROM Screening WHERE Date " + date + " ORDER BY Title";
		Cursor c = db.rawQuery(query, null);
		c.moveToFirst();
		db.close();
		return c;
	}
	
	public Screening getScreening(int ID) {
		Screening screening;
		
		SQLiteDatabase db = getReadableDatabase();
		
		String query = "SELECT * FROM SCREENING WHERE ScreeningID=" + ID + ";";
		
		Cursor c = db.rawQuery(query, null);
		
		while (c.moveToNext()) {
			int screeningID = c.getInt(c.getColumnIndex("ScreeningID"));
			int film3D = c.getInt(c.getColumnIndex("Film3D"));
			int movieID = c.getInt(c.getColumnIndex("MovieID"));
			String date = c.getString(c.getColumnIndex("Date"));
			String startTime = c.getString(c.getColumnIndex("StartTime"));
			String endTime = c.getString(c.getColumnIndex("EndTime"));
			String title = c.getString(c.getColumnIndex("Title"));
			
			screening = new Screening(screeningID, movieID, title, startTime, endTime, date, film3D);
			
			return screening;
		}
		
		return null;
	}



	/**
	 * A method that returns everything from the table Movie.
	 * @return a Cursor. Movie information.
	 */

	public Cursor getMovies() {
		SQLiteDatabase db = getReadableDatabase();

		String query = "SELECT * FROM MOVIE";
		Cursor c = db.rawQuery(query, null);
		c.moveToFirst();
		db.close();
		return c;
	}
	
	public void addTicketToDatabase(Ticket ticket, int childCount, int adultCount) {
		SQLiteDatabase db = getWritableDatabase();
		
		int ticketID = ticket.getTicketID();
		int screeningID = ticket.getScreening().getScreeningID();
		double price = ticket.getPrice();
		
		String query = "INSERT INTO Ticket (TicketID, ScreeningID, price, ChildCount, AdultCount) VALUES (" + ticketID + ", " + screeningID + ", " + price + ", " + childCount + ", " + adultCount + ");";
		db.execSQL(query);
		
		for (Seat seat : ticket.getSeats()) {
			int seatID = seat.getSeatID();
			
			String querySeat = "INSERT INTO TicketSeat (TicketID, SeatID) VALUES (" + ticketID + ", " + seatID + ");";
			db.execSQL(querySeat);
		}
		
		db.close();
	}
	
	//================================================================================
	// Settings
	//================================================================================
	
	public String getCurrentSelectedLanguage() {
		SQLiteDatabase db = getReadableDatabase();
		
		String query = "SELECT Value FROM SETTINGS WHERE Key = 'language';";
		Cursor c = db.rawQuery(query, null);
		
		String ret = "Default Language";
		
		while (c.moveToNext()) {
			ret = c.getString(c.getColumnIndex("Value"));
			ret = ret.substring(0, 1).toUpperCase() + ret.substring(1).toLowerCase();
		}
		
		db.close();
		
		return ret;
	}
	
	public void changeLanguage(String language) {
		Log.i("Database", "Change language: " + language);
		SQLiteDatabase db = getWritableDatabase();
		
		String query = "UPDATE SETTINGS SET Value = '" + language.toLowerCase() + "' WHERE Key = 'language';";
		db.execSQL(query);
		
		db.close();
	}
	
	//================================================================================
	// Account
	// Tickets
	//================================================================================
	
	public void getTickets(TicketListener listener) {
		String queryTickets = "SELECT * FROM Ticket;";
		
		SQLiteDatabase db = getReadableDatabase();
		
		Cursor c = db.rawQuery(queryTickets, null);
		
		while (c.moveToNext()) {
			Ticket ticket;
			ArrayList<Seat> seats = new ArrayList<>();
			
			int ticketID = c.getInt(c.getColumnIndex("TicketID"));
			int screeningID = c.getInt(c.getColumnIndex("ScreeningID"));
			double price = c.getDouble(c.getColumnIndex("price"));
			int childCount = c.getInt(c.getColumnIndex("ChildCount"));
			int adultCult = c.getInt(c.getColumnIndex("AdultCount"));
			Screening screening = getScreening(screeningID);
			
			String querySeats = "SELECT SeatID FROM TicketSeat WHERE TicketID=" + ticketID + ";";
			
			Cursor c2 = db.rawQuery(querySeats, null);
			
			while (c2.moveToNext()) {
				int seatID = c2.getInt(c2.getColumnIndex("SeatID"));
				Seat seat = new Seat(seatID);
				seats.add(seat);
			}
			
			listener.ticketAvailable(new Ticket(seats, ticketID, screening, price));
			
			seats.clear();
		}
	}
	
	//================================================================================
	// Account
	// History
	//================================================================================
	
	public ArrayList<Movie> getWatchedMovies(MovieListener listener) {
		ArrayList<Movie> movies = new ArrayList<>();
		
		String query = "SELECT MovieID FROM MovieHistory;";
		
		SQLiteDatabase db = getReadableDatabase();
		
		Cursor c = db.rawQuery(query, null);
		
		while (c.moveToNext()) {
			int id = c.getInt(c.getColumnIndex("MovieID"));
			Log.i("Database", "" + id);
			
			FilmManager manager = new FilmManager(listener);
			manager.findMovieById("" + id);
		}
		
		db.close();
		
		return movies;
	}

	public boolean findWatchedMovie(int MovieID) {
		String query = "SELECT * FROM MovieHistory WHERE MovieID =  " + MovieID + ";";

		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.rawQuery(query, null);

		if (!(c.moveToFirst()) || c.getCount() ==0){
			return false;
		} else {
			return true;
		}

	}
	
	public void addWatchedMovieToDatabase(Movie movie) {
		int id = movie.getMovieID();
		
		String query = "INSERT INTO MovieHistory (MovieID) VALUES (" + id + ");";
		
		SQLiteDatabase db = getWritableDatabase();
		
		db.execSQL(query);
		
		db.close();
	}
	
	//================================================================================
	// Account
	// Favorites
	//================================================================================
	
}
