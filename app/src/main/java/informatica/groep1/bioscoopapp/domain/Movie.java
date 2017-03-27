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
	
	private String title;
	private ArrayList<Actor> actors;
	private String rating;
	private String releaseYear;
	private String id;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public Movie(String title) {
		this.title = title;
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	
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
	
	public String getRating() {
		return rating;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}

	public String getId() {
		return id;
	}

	//================================================================================
	// Mutators
	//================================================================================
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addActor(Actor actor) {
		this.actors.add(actor);
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
}
