//================================================================================
// This class is made by:
// - Luka Brinkman
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseConnection extends SQLiteAssetHelper {

	private static final String DATABASE_NAME = "SQL.sqlite";
	private static final int DATABASE_VERSION = 2;

	public DatabaseConnection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
		c.moveToFirst();
		
		String ret = "Nederlands";
		
		while (c.moveToNext()) {
			ret = c.getString(c.getColumnIndex("Value"));
		}
		
		return ret;
	}
}
