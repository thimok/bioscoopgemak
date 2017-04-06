//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.businesslogic;

import android.content.Context;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.api.MovieListener;
import informatica.groep1.bioscoopapp.data.DatabaseConnection;
import informatica.groep1.bioscoopapp.domain.Movie;

public class HistoryFilmManager {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private ArrayList<Movie> movies;
	private Context context;
	private MovieListener listener;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public HistoryFilmManager(Context context, MovieListener listener) {
		movies = new ArrayList<>();
		this.context = context;
		this.listener = listener;
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	public void generate() {
		DatabaseConnection dbc = new DatabaseConnection(context);
		dbc.getWatchedMovies(listener);
	}
	
	public void add(Movie movie) {
		movies.add(movie);
	}
	
	@Deprecated
	private void demo() {
		Movie movie = new Movie("Test");
		movie.setPosterImage("https://image.tmdb.org/t/p/w1000/kqjL17yufvn9OVLyXYpvtyrFfak.jpg");
		
		Movie movie2 = new Movie("Demo");
		movie2.setPosterImage("http://image.tmdb.org/t/p/w1000/s9ye87pvq2IaDvjv9x4IOXVjvA7.jpg");
		
		movies.add(movie);
		movies.add(movie2);
		movies.add(movie2);
		movies.add(movie2);
		movies.add(movie);
		movies.add(movie);
		movies.add(movie2);
		movies.add(movie);
		movies.add(movie2);
		movies.add(movie2);
		movies.add(movie);
		movies.add(movie);
	}
}
