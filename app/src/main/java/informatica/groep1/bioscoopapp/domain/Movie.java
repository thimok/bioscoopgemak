//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.domain;

import java.util.ArrayList;

public class Movie {
	
	//================================================================================
	// Properties
	//================================================================================

	private int movieID;
	private String title;
	private ArrayList<Actor> actors;
	private double rating;
	private int releaseYear;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public Movie(int movieID, String title, double rating, int releaseYear) {
		this.movieID = movieID;
		this.title = title;
		this.rating = rating;
		this.releaseYear = releaseYear;
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
	
	public Actor getActor(String firstName, String lastName) {
		for (Actor a : actors) {
			if ((a.getFirstName().equalsIgnoreCase(firstName)) && (a.getLastName().equalsIgnoreCase(lastName))) {
				return a;
			}
		}
		return null;
	}
	
	public double getRating() {
		return rating;
	}
	
	public int getReleaseYear() {
		return releaseYear;
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
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
}
