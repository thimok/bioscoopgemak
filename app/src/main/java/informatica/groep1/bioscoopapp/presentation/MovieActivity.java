package informatica.groep1.bioscoopapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.MovieListAdapter;
import informatica.groep1.bioscoopapp.api.MovieDBAPIConnector;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import informatica.groep1.bioscoopapp.util.AlertCreator;

public class MovieActivity extends MenuActivity implements MovieDBAPIConnector.MovieListener {

    private MovieListAdapter movieListAdapter;
    private ListView listview;
    private FilmManager fManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.onCreateDrawer(toolbar, this);

        fManager = new FilmManager(this);
        fManager.findPopularMovies();

        movieListAdapter = new MovieListAdapter(this, fManager.getMovieList());

        listview = (ListView) findViewById(R.id.movieActivity_LV_movieListview);
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			    Log.i("MovieActivity", "Clicked item");
			    Intent i = new Intent(getApplicationContext(), MovieDetailed.class);
			    i.putExtra("movie", fManager.getMovieList().get(position));
			    startActivity(i);
		    }
	    });
        listview.setAdapter(movieListAdapter);
    }


    @Override
    public void onMovieAvailable(Movie movie) {
        fManager.addMovies(movie);
        movieListAdapter.notifyDataSetChanged();
        Log.i("API resultaat", movie.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);


        MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        searchView.setMenuItem(item);

        return true;
    }
	
	
	@Override
	public void onBackPressed() {
		AlertCreator creator = new AlertCreator(this);
		creator.setIcon(android.R.drawable.ic_dialog_alert);
		creator.setTitle("Exit");
		creator.setMessage("Are you sure you want to exit?");
		creator.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.gc();
				System.exit(0);
			}
		});
		creator.setNegativeButton("No", null);
		creator.show();

    }
}
