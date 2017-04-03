//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.domain;

public class Actor {
	
	//================================================================================
	// Properties
	//================================================================================

	private int actorID;
	private String name;
	private String character;
	private String imageUrl;
	private static final String TMDB_ACTOR_IMAGE_URL = "http://image.tmdb.org/t/p/w45";

	//================================================================================
	// Constructors
	//================================================================================
	public Actor( String name, int actorID, String character, String imageUrl) {
		this.name = name;
		this.actorID = actorID;
		this.character = character;
        this.imageUrl = TMDB_ACTOR_IMAGE_URL + imageUrl;
	}

	public Actor(int actorID, String name, String imageUrl) {
		this.actorID = actorID;
		this.name = name;
		this.imageUrl = imageUrl;
	}


	
	//================================================================================
	// Accessors
	//================================================================================

	
	public String getImageUrl() {
		return imageUrl;
	}

	public int getActorID() {
		return actorID;
	}

	public String getName() {
		return name;
	}

	public String getCharacter() {
		return character;
	}

	//================================================================================
	// Mutators
	//================================================================================


	public void setName(String name) {
		this.name = name;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = TMDB_ACTOR_IMAGE_URL + imageUrl;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
}
