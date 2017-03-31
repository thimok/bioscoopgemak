//================================================================================
// This class is made by:
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.businesslogic;

import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import informatica.groep1.bioscoopapp.api.MovieDBAPIConnector;
import informatica.groep1.bioscoopapp.api.MovieDetailedAPIConnector;
import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.domain.Movie;

import static informatica.groep1.bioscoopapp.api.MovieDBAPIConnector.API_KEY;
import static informatica.groep1.bioscoopapp.api.MovieDBAPIConnector.TMDB_API_BASE;

public class FilmManager {


    MovieListener listener;
    ArrayList<Movie> movies;
    View mdView;


    public static final String TMDB_METHOD_SEARCH = "/search";
    public static final String TMDB_METHOD_DISCOVER = "/discover";
    public static final String TMD_METHOD_MOVIE = "/movie";

    public static final String PARAM_SORT_BY_POPULARITY_DESC = "&sort_by=popularity.desc";
    public static final String PARAM_SORT_BY_RELEASE_DATE_DESC = "&sort_by=primary_release_date.desc";
    public static final String PARAM_ONLY_INCLUDE_SPECIFIED_RELEASE_DATE_AND_LESSER = "&primary_release_date.lte=";
    public static final String PARAM_SORT_BY_ADULT_TRUE = "&include_adult=true";
    public static final String PARAM_SORT_BY_ADULT_FALSE = "&include_adult=false";
    public static final String PARAM_SORT_BY_VOTE = "&sort_by=vote_average.desc";
    public static final String PARAM_SORT_BY_TITLE = "&sort_by=original_title.asc";
    public static final String PARAM_MOVIE_ID = "/";


    public FilmManager(MovieListener listener) {
        this.movies = new ArrayList<Movie>();
        this.listener = listener;
    }

    public FilmManager(MovieListener listener, View mdView) {
        this(listener);
        this.mdView = mdView;
    }

    public void findPopularMovies() {

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDBAPIConnector connector = new MovieDBAPIConnector(listener);
        String[] urls = new String[] {TMDB_API_BASE + TMDB_METHOD_DISCOVER
                + TMD_METHOD_MOVIE + API_KEY + PARAM_SORT_BY_POPULARITY_DESC + PARAM_SORT_BY_ADULT_FALSE };
        connector.execute(urls);
    }

    public void findRecentMovies() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fDate = sdf.format(date);

        Log.i("DATE", fDate);

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDBAPIConnector connector = new MovieDBAPIConnector(listener);
        String[] urls = new String[] {TMDB_API_BASE + TMDB_METHOD_DISCOVER
                + TMD_METHOD_MOVIE + API_KEY + PARAM_SORT_BY_RELEASE_DATE_DESC
                + PARAM_ONLY_INCLUDE_SPECIFIED_RELEASE_DATE_AND_LESSER + fDate
                + PARAM_SORT_BY_ADULT_FALSE};
        connector.execute(urls);
    }

    public void findAdultMovies() {

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDBAPIConnector connector = new MovieDBAPIConnector(listener);
        String[] urls = new String[] {TMDB_API_BASE + TMDB_METHOD_DISCOVER
                + TMD_METHOD_MOVIE + API_KEY + PARAM_SORT_BY_ADULT_TRUE };
        connector.execute(urls);
    }

    public void findRatedMovies() {

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDBAPIConnector connector = new MovieDBAPIConnector(listener);
        String[] urls = new String[] {TMDB_API_BASE + TMDB_METHOD_DISCOVER
                + TMD_METHOD_MOVIE + API_KEY + PARAM_SORT_BY_VOTE
                + PARAM_SORT_BY_ADULT_FALSE};
        connector.execute(urls);
    }

    public void findMoviesByTitle() {

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDBAPIConnector connector = new MovieDBAPIConnector(listener);
        String[] urls = new String[] {TMDB_API_BASE + TMDB_METHOD_DISCOVER
                + TMD_METHOD_MOVIE + API_KEY + PARAM_SORT_BY_TITLE
                /*+ PARAM_SORT_BY_ADULT_FALSE*/};
        connector.execute(urls);
    }

    public void findMovieDetails(String movieID) {

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDetailedAPIConnector connector = new MovieDetailedAPIConnector(listener, mdView);
        String[] urls = new String[] {TMDB_API_BASE
                + TMD_METHOD_MOVIE + PARAM_MOVIE_ID + movieID + API_KEY
                };
        connector.execute(urls);
    }





    public ArrayList<Movie> getMovieList() {
        return movies;
    }

    public void addMovies(Movie movie) {
        movies.add(movie);
    }


}
