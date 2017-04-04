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

public class DatabaseConnection extends SQLiteAssetHelper {


    private static final String DATABASE_NAME = "SQL.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Hier de CRUD methoden
    public Cursor getShowNames(String date) {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT Title, MovieID, ScreeningID FROM Screening WHERE Date = '2017-04-03' GROUP BY Title ORDER BY Title";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        db.close();
        return c;
    }

    public Cursor getShowTimes() {

		SQLiteDatabase db = getReadableDatabase();

		String query = "SELECT Title, StartTime, EndTime, MovieID, ScreeningID, Film3D, Date FROM Screening WHERE Date = '2017-04-03' ORDER BY Title";
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
	
	
}
