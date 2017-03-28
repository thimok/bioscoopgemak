//================================================================================
// This class is made by:
//
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Movie;

public class MovieListAdapter extends ArrayAdapter<Movie> {

	public static final String TMDB_POSTER_URL_BASE = "http://image.tmdb.org/t/p/w1000/";

	public MovieListAdapter(@NonNull Context context, @NonNull List<Movie> movies) {
		super(context, 0, movies);
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		Movie movie = (Movie) getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_movie_list, parent, false);
		}

		ImageView headerImage = (ImageView) convertView.findViewById(R.id.movieActivity_IV_headerImage);
		Picasso.with(getContext())
				.load(TMDB_POSTER_URL_BASE + movie.getBackDropImage())
				/*.placeholder(R.drawable.imagenotfound)
				.error(R.drawable.imagenotfound)*/
				.fit()
				.into(headerImage);

		TextView title = (TextView) convertView.findViewById(R.id.movieActivity_TV_title);
        title.setText(movie.getTitle());



		TextView rating = (TextView) convertView.findViewById(R.id.movieActivity_TV_rating);
		rating.setText(movie.getRating());

		TextView date = (TextView) convertView.findViewById(R.id.movieActivity_TV_date);
		date.setText(movie.getReleaseYear());



		return convertView;
	}
}
