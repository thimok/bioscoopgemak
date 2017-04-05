//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;


import java.io.Serializable;

public class Genre implements Serializable {
    
    //================================================================================
    // Properties
    //================================================================================
	
    private int genreID;
    private String genre;

    //================================================================================
    // Constructors
    //================================================================================
	
    public Genre(int genreID, String genre){
        this.genreID = genreID;
        this.genre = genre;
    }

    //================================================================================
    // Accessors
    //================================================================================
	
    public int getGenreID() {
        return genreID;
    }
    
    public String getGenre() {
        return genre;
    }

    //================================================================================
    // Mutators
    // ================================================================================
	
    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
