//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import informatica.groep1.bioscoopapp.R;

public class MovieListAdapter extends CursorAdapter {
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public MovieListAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.row_movie_list, parent, false);
		return view;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		//Textviews en die shit komt hier
	}
}
