//================================================================================
// This class is made by:
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.api;

import informatica.groep1.bioscoopapp.domain.Movie;

public interface MovieListener {
    public void onMovieAvailable(Movie movie);
}
