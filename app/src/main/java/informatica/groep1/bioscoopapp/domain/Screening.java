package informatica.groep1.bioscoopapp.domain;

//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

import java.io.Serializable;

public class Screening implements Serializable {

    //================================================================================
    // Properties
    //================================================================================

    public  int screeningID;
    public String startTime;
    public String endTime;
    public Boolean film3D;
    public Movie movie;
    public Auditorium auditorium;
    public String playDate;

    //================================================================================
    // Constructors
    //================================================================================

    public Screening(int screeningID, String startTime, String endTime, String playDate,
                     Auditorium auditorium, Movie movie, boolean film3D)

    {
        this.screeningID = screeningID;
        this.startTime = startTime;
        this.auditorium = auditorium;
        this.film3D = film3D;
        this.movie = movie;
        this.endTime = endTime;
        this.playDate = playDate;

    }

    //================================================================================
    // Accessors
    //================================================================================
    public String getEndTime() {
        return endTime;
    }

    public Auditorium getAuditorium() {

        return auditorium;

    }

    public Movie getMovie() {

            return movie;
        }

    public Boolean getFilm3D() {

        return film3D;
    }

    public int getScreeningID() {

        return screeningID;
    }

    public String getPlayDate() {
        return playDate;
    }

    //================================================================================
    // Mutators
    //================================================================================


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }


    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public void setFilm3D(Boolean film3D) {
        this.film3D = film3D;
    }



    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public String getStartTime() {

        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }




    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }





}
