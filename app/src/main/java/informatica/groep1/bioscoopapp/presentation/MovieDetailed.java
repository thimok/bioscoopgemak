//================================================================================
// This class is made by:
// - Sven Westerlaken
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.ActorListAdapter;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Actor;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.util.PixelSizeConverter;

import static android.R.interpolator.accelerate_quad;

public class MovieDetailed extends AppCompatActivity implements MovieListener {
	private static final String TMDB_POSTER_URL_BASE = "http://image.tmdb.org/t/p/w1000/";

    boolean previous = true;
    private ImageView posterImage;
    private TextView title, releasedate;
    private Animation animationOut, animationIn, textAnimationIn, textAnimationOut;
	private LinearLayout subinfoContainer;
	private Movie movie;
	private FilmManager fManager;
	private View thisView;
	private ListView actorList;
	
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
				Toast toast = Toast.makeText(getApplicationContext(), "Function not implemented", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		
		Bundle extras = getIntent().getExtras();
		movie = (Movie) extras.getSerializable("Movie");
		thisView = this.findViewById(android.R.id.content);
		String imgurl = TMDB_POSTER_URL_BASE + movie.getBackDropImage();
		String posterimgurl = TMDB_POSTER_URL_BASE + movie.getPosterImage();
		
		releasedate = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_date);
		title = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_title);
        posterImage = (ImageView) findViewById(R.id.movieDetailedActivity_IV_posterImage);
		subinfoContainer = (LinearLayout) findViewById(R.id.movieDetailedActivity_subinfoContainer);
		actorList = (ListView) findViewById(R.id.movieDetailedActivity_LV_cast);

		TextView rating = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_rating);
		TextView description = (RobotoTextView) findViewById(R.id.movieDetailedActivity_TV_description);
		ImageView headerImage = (ImageView) findViewById(R.id.movieDetailedActivity_IV_headerImage);

		Picasso.with(getApplicationContext()).load(imgurl).error(R.drawable.missingimage).into(headerImage);
		Picasso.with(getApplicationContext()).load(posterimgurl).error(R.drawable.missingimage).into(posterImage);
		releasedate.setText(movie.getReleaseYear());
		title.setText(movie.getTitle());
		rating.setText(movie.getRating());
		description.setText(movie.getLongDescription());

        AppBarLayout CollapseToolBar = (AppBarLayout) findViewById(R.id.app_bar);

		float textDeltaX = -1 * PixelSizeConverter.convertDPtoPX(getApplicationContext(), 118);

        animationOut = AnimationUtils.loadAnimation(this, R.anim.movie_poster_out);
        animationIn = AnimationUtils.loadAnimation(this, R.anim.movie_poster_in);

        textAnimationOut = new TranslateAnimation(0, textDeltaX, 0, 0);
		textAnimationOut.setDuration(250);
		textAnimationOut.setFillAfter(true);
		textAnimationOut.setInterpolator(new AccelerateInterpolator());

		textAnimationIn = new TranslateAnimation(textDeltaX, 0, 0, 0);
		textAnimationIn.setDuration(250);
		textAnimationIn.setFillAfter(true);
		textAnimationIn.setInterpolator(new AccelerateInterpolator());

		fManager = new FilmManager(this, thisView);
		fManager.findMovieDetails("" + movie.getMovieID());
		
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

	}

	@Override
	public void onMovieAvailable(Movie movie) {
		if(this.movie.getMovieID() == movie.getMovieID()) {
			ArrayList<Actor> actors = movie.getActors();
			ActorListAdapter aa = new ActorListAdapter(this, getLayoutInflater(), actors);
			actorList.setAdapter(aa);

            ImageView directorImage = (ImageView) findViewById(R.id.detailedMovieActivity_IV_directorImage);
            String directorImageURL = movie.getDirector().getImageUrl();

            Picasso.with(getApplicationContext()).load(directorImageURL).error(R.drawable.placeholder_user).placeholder(R.drawable.placeholder_user).into(directorImage);
		}
	}

    private void updateBoolean(boolean expanded) {

        if (expanded != previous) {
            if(expanded) {
                posterImage.startAnimation(animationIn);
				releasedate.startAnimation(textAnimationIn);
				title.startAnimation(textAnimationIn);
				subinfoContainer.startAnimation(textAnimationIn);
                this.previous = true;
            } else {
                posterImage.startAnimation(animationOut);
				releasedate.startAnimation(textAnimationOut);
				title.startAnimation(textAnimationOut);
				subinfoContainer.startAnimation(textAnimationOut);
                this.previous = false;
            }

        }
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// 'home' is the id for the icon click in the action bar (i.e. up/back).
		if (item.getItemId() == android.R.id.home) {
			onBackPressed();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	
}
