package informatica.groep1.bioscoopapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by lukab on 28-3-2017.
 */

public class DatabaseConnection extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "SQL.sqlite";
    private static final int DATABASE_VERSION = 1;

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


}
