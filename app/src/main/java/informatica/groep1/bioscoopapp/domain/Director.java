//================================================================================
// This class is made by:
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.domain;

import java.io.Serializable;

public class Director implements Serializable {
    
    //================================================================================
    // Properties
    //================================================================================
    
    private int ID;
    private String name;
    private String imageUrl;
    private static final String TMDB_ACTOR_IMAGE_URL = "http://image.tmdb.org/t/p/w45";

	//================================================================================
	// Constructors
	//================================================================================
	
    public Director(int ID, String name, String imageUrl) {
        this.ID = ID;
        this.name = name;
        this.imageUrl = TMDB_ACTOR_IMAGE_URL + imageUrl;
    }

    //================================================================================
    // Accessors
    //================================================================================
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    //================================================================================
    // Mutators
    //================================================================================
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imagePath) {
        this.imageUrl = TMDB_ACTOR_IMAGE_URL + imagePath;
    }
}
