//================================================================================
// This class is made by:
// - Sven Westerlaken
//================================================================================


package informatica.groep1.bioscoopapp.domain;

import java.io.Serializable;

/**
 * Created by Sven on 4-4-2017.
 */


public class ShowTitleRow implements Serializable {
    private int screeningID;
    private String title;

    public ShowTitleRow(int screeningID, String title) {
        this.screeningID = screeningID;
        this.title = title;
    }
    
    public ShowTitleRow() {
        
    }

    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
