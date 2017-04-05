//================================================================================
// This class is made by:
// - Sven Westerlaken
//================================================================================


package informatica.groep1.bioscoopapp.domain;

import java.io.Serializable;

public class ShowTitleRow implements Serializable {

    //================================================================================
    // Properties
    //================================================================================

    private int screeningID;
    private String title;

    //================================================================================
    //Constructor
    //================================================================================

    public ShowTitleRow(int screeningID, String title) {
        this.screeningID = screeningID;
        this.title = title;
    }

    //================================================================================
    // Accessors
    //================================================================================
    public int getScreeningID() {
        return screeningID;
    }

    public String getTitle() {
        return title;
    }

    //================================================================================
    // Mutators
    //================================================================================

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }


    public void setTitle(String title) {
        this.title = title;
    }
}
