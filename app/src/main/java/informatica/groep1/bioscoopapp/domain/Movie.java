//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	
	//================================================================================
	// Properties
	//================================================================================

	private int movieID;
	private String title;
	private ArrayList<Actor> actors;
    private ArrayList<Genre> genres;
	private String rating;
	private String releaseYear;
	private String backDropImage;
	private String posterImage;
    private int length;
    private String longDescription;
    private Director director;
    private boolean adult;

	
	//================================================================================
	// Constructors
	//================================================================================

	public Movie(int movieID, String title, String rating, String releaseYear) {
		this.movieID = movieID;
		this.title = title;
		this.rating = rating;
		this.releaseYear = releaseYear;
	}
	
	public Movie(String title) {

		this.title = title;
	}

	public Movie() {
        genres = new ArrayList<Genre>();
		actors = new ArrayList<Actor>();
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	public int getMovieID() {
		return movieID;
	}

	public String getTitle() {
		return title;
	}
	
	public ArrayList<Actor> getActors() {
		return actors;
	}
	
	public Actor getActor(String name) {
		for (Actor a : actors) {
			if (a.getName().equalsIgnoreCase(name)) {
				return a;
			}
		}
		return null;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}

	public String getBackDropImage() {
		return backDropImage;
	}

	public String getPosterImage() {
		return posterImage;
	}

	public int getLength() {
        return length;
    }

    public String getLongDescription() {
        return longDescription;
    }

	public Director getDirector() {
		return director;
	}

	public boolean isAdult() {
        return adult;
    }

    //================================================================================
	// Mutators
	//================================================================================
	
	public void setTitle(String title) {
		this.title = title;
	}


	public void addActor(Actor actor) {
		this.actors.add(actor);
	}

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }
	
	public void setRating(String rating) {
		this.rating = rating;
	}

    public void setLength(int length) {
        this.length = length;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

	public void setDirector(Director director) {
		this.director = director;
	}

	public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	
	public void setBackDropImage(String backDropImage) {
		this.backDropImage = backDropImage;
	}

	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
}
