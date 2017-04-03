package informatica.groep1.bioscoopapp.domain;

/**
 * Created by twanv on 31-3-2017.
 */

public class Director {
    private int ID;
    private String name;
    private String imageUrl;
    private static final String TMDB_ACTOR_IMAGE_URL = "http://image.tmdb.org/t/p/w45";

    public Director(int ID, String name, String imageUrl) {
        this.ID = ID;
        this.name = name;
        this.imageUrl = TMDB_ACTOR_IMAGE_URL + imageUrl;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

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
