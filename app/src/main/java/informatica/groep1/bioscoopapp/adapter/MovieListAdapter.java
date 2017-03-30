//================================================================================
// This class is made by:
//
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.presentation.MovieDetailed;

public class MovieListAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<Movie> movies;

	private static final String TMDB_POSTER_URL_BASE = "http://image.tmdb.org/t/p/w1000/";

	public MovieListAdapter(Context context, LayoutInflater inflater, ArrayList<Movie> movies) {
		this.context = context;
		this.inflater = inflater;
		this.movies = movies;
	}

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
		ViewHolder viewHolder;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row_movie_list, null);

			viewHolder = new ViewHolder();
			viewHolder.backdrop = (ImageView) convertView.findViewById(R.id.movieActivity_IV_headerImage);
			viewHolder.title = (RobotoTextView) convertView.findViewById(R.id.movieActivity_TV_title);
			viewHolder.releasedate = (RobotoTextView) convertView.findViewById(R.id.movieActivity_TV_date);
			viewHolder.rating = (RobotoTextView) convertView.findViewById(R.id.movieActivity_TV_rating);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		final Movie movie = movies.get(position);
		String imgurl = TMDB_POSTER_URL_BASE + movie.getBackDropImage();
		ImageView overlay = (ImageView) convertView.findViewById(R.id.movieActivity_IV_headerImageOverlay);

		viewHolder.title.setText(movie.getTitle());
		viewHolder.releasedate.setText(movie.getReleaseYear());
		viewHolder.rating.setText(movie.getRating());
		Picasso.with(context).load(imgurl).into(viewHolder.backdrop);

		overlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, MovieDetailed.class);
				i.putExtra("Movie", movie);
				context.startActivity(i);
			}
		});


		return convertView;
	}

	private static class ViewHolder {
		ImageView backdrop;
		TextView title, releasedate, rating;
	}
}
