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

import informatica.groep1.bioscoopapp.api.MovieDBAPIConnector;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;

public class DatabaseConnection extends SQLiteAssetHelper {


    private static final String DATABASE_NAME = "SQL.sqlite";
    private static final int DATABASE_VERSION = 2;

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Hier de CRUD methoden
    public Cursor getShowNames(String date) {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT Title, MovieID, ScreeningID as _id FROM Screening WHERE Date = '2017-04-03' GROUP BY Title ORDER BY Title";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        db.close();
        return c;
    }

    public Cursor getShowTimes() {

		SQLiteDatabase db = getReadableDatabase();

		String query = "SELECT StartTime, MovieID, ScreeningID as _id FROM Screening WHERE Date = '2017-04-03' AND MovieID = 315837";
		Cursor c = db.rawQuery(query, null);
		c.moveToFirst();
		db.close();
		return c;

	}


	// Hier de CRUD methoden
	public Cursor getMovies() {
		SQLiteDatabase db = getReadableDatabase();

		String query = "SELECT * FROM MOVIE";
		Cursor c = db.rawQuery(query, null);
		c.moveToFirst();
		db.close();
		return c;
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
