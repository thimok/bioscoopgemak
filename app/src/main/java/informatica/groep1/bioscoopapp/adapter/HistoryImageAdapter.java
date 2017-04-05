//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Ticket;

public class HistoryImageAdapter extends ArrayAdapter<Movie> {
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public HistoryImageAdapter(Context context, ArrayList<Movie> movies) {
		super(context, 0, movies);
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Movie movie = getItem(position);
		
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_movie_poster, parent, false);
		}
		
		ImageView iv = (ImageView) convertView.findViewById(R.id.rowMovie_IV_poster);
		
		Picasso.with(convertView.getContext()).load(movie.getPosterImage()).into(iv);
		Log.i("Adapter", movie.getPosterImage());
		
		return convertView;
	}
}
