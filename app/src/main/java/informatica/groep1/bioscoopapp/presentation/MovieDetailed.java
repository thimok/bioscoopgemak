package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Actor;
import informatica.groep1.bioscoopapp.domain.Movie;

public class MovieDetailed extends AppCompatActivity implements MovieListener {
	private static final String TMDB_POSTER_URL_BASE = "http://image.tmdb.org/t/p/w1000/";

    boolean previous = true;
    private ImageView posterImage;
    private Animation animationOut, animationIn;
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
        posterImage = (ImageView) findViewById(R.id.movieDetailedActivity_IV_posterImage);

        AppBarLayout CollapseToolBar = (AppBarLayout) findViewById(R.id.app_bar);

        animationOut = AnimationUtils.loadAnimation(this, R.anim.movie_poster_out);
        animationIn = AnimationUtils.loadAnimation(this, R.anim.movie_poster_in);

		// voeg hier ook imageview toe met poster url @sven.
		// haal hier ook longdescription op en posterURL uit movie die met
		// intent is meegegeven op.

		Picasso.with(getApplicationContext()).load(imgurl).into(headerImage);
		releasedate.setText(movie.getReleaseYear());
		title.setText(movie.getTitle());
		rating.setText(movie.getRating());

<<<<<<< HEAD
        CollapseToolBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //  Vertical offset == 0 indicates appBar is fully expanded.
                if (Math.abs(verticalOffset) > 200) {
                    updateBoolean(false);
                } else {
                    updateBoolean(true);
                }
            }
        });

=======
		thisView = this.findViewById(android.R.id.content);

		fManager = new FilmManager(this, thisView);
		fManager.findMovieDetails("" + movie.getMovieID());

	}

	@Override
	public void onMovieAvailable(Movie movie) {
		if(this.movie.getMovieID() == movie.getMovieID()) {
			// haal actor arraylijst op met movie.getActors() en instantieer hem
			// of geef gelijk door aan adapter

			// test om te laten zien dat actors opgehaald worden max 6
			ArrayList<Actor> actors = movie.getActors();

			for (Actor a : actors) {
				Log.i("ACTOR", a.getName() + " " + a.getCharacter());
			}
		}
		/*fManager.addMovies(movie);
		movieListAdapter.notifyDataSetChanged();
		Log.i("API resultaat", movie.getTitle());*/
>>>>>>> a6ad2135e36f8efd38aa9cf39fed2a823f7d6656
	}

    private void updateBoolean(boolean expanded) {

        if (expanded != previous) {

            if(expanded) {
                Log.i("test", "Animatie 2 gestart");
                posterImage.startAnimation(animationIn);
                this.previous = true;
            } else {
                posterImage.startAnimation(animationOut);
                Log.i("test", "Animatie gestart");
                this.previous = false;
            }

        }
    }
	
}
