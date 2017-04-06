//================================================================================
// This class is made by:
// - Luka Brinkman
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.domain;

public class Screening extends ShowTitleRow {

	//================================================================================
	// Properties
	//================================================================================

	private String startTime;
	private String endTime;
	private int film3D;
	private String playDate;
	private int screeningID;
	private String title;
	private int MovieID;
	private Movie movie;
	
	//================================================================================
	// Constructors
	//================================================================================

	public Screening(int screeningID, int movieID, String title, String startTime, String endTime, String playDate, int film3D) {
		super(screeningID, title);
		this.startTime = startTime;
		this.film3D = film3D;
		this.endTime = endTime;
		this.playDate = playDate;
		this.MovieID = movieID;
	}

	//================================================================================
	// Accessors
	//================================================================================
	
	public String getEndTime() {
		return endTime;
	}
	
	public boolean getIs3D() {
		if(film3D == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	public int getScreeningID() {
		return super.getScreeningID();
	}

	public String getPlayDate() {
		return playDate;
	}

	public int getMovieID() {
		return MovieID;
	}

	//================================================================================
	// Mutators
	//================================================================================


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}


	public void setFilm3D(int film3D) {
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

	public void setMovieID(int movieID) {
		MovieID = movieID;
	}
}
