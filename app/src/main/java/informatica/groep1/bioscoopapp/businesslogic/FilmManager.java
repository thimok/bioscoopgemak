package informatica.groep1.bioscoopapp.businesslogic;

import android.util.Log;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.api.MovieDBAPIConnector;
import informatica.groep1.bioscoopapp.domain.Movie;

/**
 * Created by twanv on 28-3-2017.
 */

public class FilmManager {

    MovieDBAPIConnector.MovieListener listener;
    ArrayList<Movie> movies;
    public static final String TMDB_API_BASE = "https://api.themoviedb.org/3";
    public static final String TMDB_METHOD_SEARCH = "/search";
    public static final String TMDB_METHOD_DISCOVER = "/discover";
    public static final String TMD_METHOD_MOVIE = "/movie";
    public static final String API_KEY = "?api_key=f5432ebc636370b7954317a342043046";
    public static final String PARAM_SORT_BY_POPULARITY_DESC = "&sort_by=popularity.desc";

    public FilmManager(MovieDBAPIConnector.MovieListener listener) {
        this.movies = new ArrayList<Movie>();
        this.listener = listener;
    }

    public void findPopularMovies() {

        if(!movies.isEmpty()) {
            movies.clear();
        }

        MovieDBAPIConnector connector = new MovieDBAPIConnector(listener);
        String[] urls = new String[] {TMDB_API_BASE + TMDB_METHOD_DISCOVER
                + TMD_METHOD_MOVIE + API_KEY + PARAM_SORT_BY_POPULARITY_DESC };
        connector.execute(urls);
    }

    public ArrayList<Movie> getMovieList() {
        return movies;
    }

    public void addMovies(Movie movie) {
        movies.add(movie);
    }


}
