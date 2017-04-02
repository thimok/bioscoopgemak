package informatica.groep1.bioscoopapp.presentation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.MovieListAdapter;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.businesslogic.FilmManager;
import informatica.groep1.bioscoopapp.domain.Movie;
import informatica.groep1.bioscoopapp.util.AlertCreator;

public class MovieActivity extends MenuActivity implements MovieListener {

    private MovieListAdapter movieListAdapter;
    private ListView listview;
    private FilmManager fManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        super.onCreateDrawer(toolbar, this);

        fManager = new FilmManager(this);

        listview = (ListView) findViewById(R.id.movieActivity_LV_movieListview);
        movieListAdapter = new MovieListAdapter(this, getLayoutInflater(), fManager.getMovieList());
        listview.setAdapter(movieListAdapter);

    }

    @Override
    public void onMovieAvailable(Movie movie) {
        fManager.addMovies(movie);
        movieListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        //ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.activity_movie_spinner, android.R.id.text1, getResources().getStringArray(R.array.movie_filter_array));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getSupportActionBar().getThemedContext(), R.array.movie_filter_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String filter = parent.getItemAtPosition(position).toString();
                String sPopular = getResources().getString(R.string.popular);
                String sRecent = getResources().getString(R.string.recent);
                String sAdult = getResources().getString(R.string.adult);
                String sRating = getResources().getString(R.string.rating);
                String sTitle = getResources().getString(R.string.title);

                if (filter.equals(sPopular)) {
                    fManager.findPopularMovies();
                } else if (filter.equals(sRecent)) {
                    fManager.findRecentMovies();
                } else if (filter.equals(sAdult)) {
                    fManager.findAdultMovies();
                } else if (filter.equals(sRating)) {
                    fManager.findRatedMovies();
                }  else if (filter.equals(sTitle)) {
                    fManager.findMoviesByTitle();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        MenuItem itemSearch = menu.findItem(R.id.action_search);

        MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fManager.findMovieByQuery(query);
                return true;
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

        searchView.setMenuItem(itemSearch);

        return super.onCreateOptionsMenu(menu);
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
