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
	private String firstName;
	private String lastName;
	private String imageUrl;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public Actor(int actorID, String firstName, String lastName, String imageUrl) {
		this.actorID = actorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.imageUrl = imageUrl;
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public int getActorID() {
		return actorID;
	}

	//================================================================================
	// Mutators
	//================================================================================
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
}
