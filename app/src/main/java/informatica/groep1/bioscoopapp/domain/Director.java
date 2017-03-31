package informatica.groep1.bioscoopapp.domain;

/**
 * Created by twanv on 31-3-2017.
 */

public class Director {
    private int ID;
    private String name;

    public Director(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
