package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.api.MovieDBAPIConnector;
import informatica.groep1.bioscoopapp.domain.Movie;

public class MovieActivity extends MenuActivity implements MovieDBAPIConnector.MovieListener {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.onCreateDrawer(toolbar, this);

        getMovies();
    }

    public void getMovies() {
        MovieDBAPIConnector task = new MovieDBAPIConnector(this);
        String[] urls = new String[] {"https://api.themoviedb.org/3/search/movie?api_key=f5432ebc636370b7954317a342043046&query=Jack+Reacher"};
        task.execute(urls);
    }


    @Override
    public void onMovieAvailable(Movie movie) {

            Log.i("API resultaat", movie.getTitle());

    }
}
