package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;

public class MovieDetailed extends AppCompatActivity implements MovieListener {
	private static final String TMDB_POSTER_URL_BASE = "http://image.tmdb.org/t/p/w1000/";

	private TextView test;
	private Movie movie;
	private FilmManager fManager;
	private View thisView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie_detailed);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		
		Bundle extras = getIntent().getExtras();
		movie = (Movie) extras.getSerializable("Movie");
		String imgurl = TMDB_POSTER_URL_BASE + movie.getBackDropImage();
		
		TextView releasedate = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_date);
		TextView title = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_title);
		TextView rating = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_rating);
		ImageView headerImage = (ImageView) findViewById(R.id.movieDetailedActivity_IV_headerImage);

		Picasso.with(getApplicationContext()).load(imgurl).into(headerImage);
		releasedate.setText(movie.getReleaseYear());
		title.setText(movie.getTitle());
		rating.setText(movie.getRating());

		thisView = this.findViewById(android.R.id.content);

		fManager = new FilmManager(this, thisView);
		fManager.findMovieDetails("" + movie.getMovieID());

	}

	@Override
	public void onMovieAvailable(Movie movie) {
		if(this.movie.getMovieID() == movie.getMovieID()) {
			// haal actor arraylijst op met movie.getActors() en instantieer hem
			// of geef gelijk door aan adapter
		}
		/*fManager.addMovies(movie);
		movieListAdapter.notifyDataSetChanged();
		Log.i("API resultaat", movie.getTitle());*/
	}
	
}
