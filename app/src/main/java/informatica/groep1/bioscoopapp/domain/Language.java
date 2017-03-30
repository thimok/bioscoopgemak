//================================================================================
// This class is made by:
// - Devon Marsham
//================================================================================

package informatica.groep1.bioscoopapp.domain;

public class Language {
    //================================================================================
    // Properties
    //================================================================================
    private int languageiD;
    private String langauge;

    //================================================================================
    // Constructer
    //================================================================================
    public Language(int languageiD, String langauge){
        this.languageiD = languageiD;
        this.langauge = langauge;
    }
    //================================================================================
    // Accessors
    //================================================================================

    public int getLanguageiD() {
        return languageiD;
    }

    public String getLangauge() {
        return langauge;
    }
    //================================================================================
    // Mutators
    //================================================================================

    public void setLanguageiD(int languageiD) {
        this.languageiD = languageiD;
    }

    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }
}
