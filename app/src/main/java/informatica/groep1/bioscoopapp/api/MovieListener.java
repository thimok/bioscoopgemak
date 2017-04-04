package informatica.groep1.bioscoopapp.api;

import informatica.groep1.bioscoopapp.domain.Movie;

/**
 * Created by twanv on 31-3-2017.
 */

public interface MovieListener {
    public void onMovieAvailable(Movie movie);
}
