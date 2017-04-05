//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.content.Intent;
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
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.domain.Ticket;
import informatica.groep1.bioscoopapp.presentation.MovieDetailed;

public class HistoryImageAdapter extends BaseAdapter {
	private ArrayList<Movie> movies;
	private LayoutInflater inflater;
	private Context context;
	private GridView gridView;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public HistoryImageAdapter(Context context, ArrayList<Movie> movies, LayoutInflater inflater, GridView gv) {

		this.context = context;
		this.movies = movies;
		this.inflater = inflater;
		this.gridView = gv;
	}
	
	//================================================================================
	// Accessors
	//================================================================================

	@Override
	public int getCount() {
		return movies.size();
	}

	@Override
	public Object getItem(int position) {
		return movies.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Movie movie = (Movie) getItem(position);

		final int imageWidth = gridView.getColumnWidth();
		final int imageHeight = imageWidth / 2 * 3;


		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row_movie_poster, null);
		}
		
		ImageView iv = (ImageView) convertView.findViewById(R.id.rowMovie_IV_poster);
		
		Picasso.with(context).load(movie.getPosterImage()).resize(imageWidth, imageHeight).into(iv);

		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, MovieDetailed.class);
				i.putExtra("Movie", movie);
				DatabaseConnection dbc = new DatabaseConnection(v.getContext());
				context.startActivity(i);
			}
		});
		
		return convertView;
	}
}
