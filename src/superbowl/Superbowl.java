package superbowl;

import java.time.LocalDate;

/**
 * @author charmainpedrigal
 *<h1>Base Class</h1>
 *This class contains get and set methods to be able to access and update data the value of a private variable.
 */
public class Superbowl implements Comparable<Superbowl> {
	private LocalDate date;
	private int attendance;
	private String winner;
	private int winningPoints;
	private String loser;
	private int losingPoints;
	private String mvp;
	private String stadium;
	private String city;
	private String state;
	private int pointDifference;
	boolean win = false;
	private int num;

	/**
	 * This method is the constructor class that accepts all these variables.
	 * @param date - accepts LocalDate.
	 * @param attendance - accepts integer.
	 * @param winner - accepts string.
	 * @param winningPoints - accepts integer.
	 * @param loser - accepts string.
	 * @param losingPoints - accepts integer.
	 * @param mvp - accepts string.
	 * @param stadium - accepts string.
	 * @param city - accepts string.
	 * @param state - accepts string.
	 * @param pointDifference - accepts integer.
	 */
	public Superbowl(LocalDate date, int attendance, String winner, int winningPoints, String loser, int losingPoints,
			String mvp, String stadium, String city, String state, int pointDifference) {
		this.date = date;
		this.attendance = attendance;
		this.winner = winner;
		this.winningPoints = winningPoints;
		this.loser = loser;
		this.losingPoints = losingPoints;
		this.mvp = mvp;
		this.stadium = stadium;
		this.city = city;
		this.state = state;
		this.pointDifference = pointDifference;
	}
	
	
	/**
	 * This method is used for a unit test.
	 * @param num - accepts an integer.
	 */
	public Superbowl(int num)
	{
		this.num = num;
	}

	/**
	 * This method gets the current date data of the variable.
	 * @return - It returns the date value as a LocalDate datatype.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * This method gets the current attendance data of the variable.
	 * @return - It returns the attendance value as an integer datatype.
	 */
	public int getAttendance() {
		return attendance;
	}

	/**
	 * This method gets the current winner data of the variable.
	 * @return - It returns the winner value as a string datatype.
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * This method gets the current winning point data of the variable.
	 * @return - It returns the winning point value as an integer datatype.
	 */
	public int getWinningPoints() {

		return winningPoints;
	}
	
	/**
	 * This method gets the current loser data of the variable.
	 * @return - It returns the loser value as a string datatype.
	 */
	public String getLoser() {
		return loser;
	}

	/**
	 * This method gets the current losing point data of the variable.
	 * @return - It returns the losing point value as an integer datatype.
	 */
	public int getLosingPoints() {
		return losingPoints;
	}

	/**
	 * This method gets the current mvp data of the variable.
	 * @return - It returns the mvp value as a string datatype.
	 */
	public String getMvp() {
		return mvp;
	}

	/**
	 * This method gets the current stadium data of the variable.
	 * @return - It returns the stadium value as a string datatype.
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * This method gets the current city data of the variable.
	 * @return - It returns the city value as a string datatype.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method gets the current state data of the variable.
	 * @return - It returns the state value as a string datatype.
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method gets the current point difference data of the variable.
	 * @return - It returns the point difference value as an integer datatype.
	 */
	public int getPointDifference() {
		return pointDifference;
	}

	/**
	 * This method sets the current date value.
	 * @param date - accepts a LocalDate datatype.
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * This method sets the current attendance value.
	 * @param attendance - accepts an integer datatype.
	 */
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	/**
	 * This method sets the current winner value.
	 * @param winner - accepts a string datatype.
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/**
	 * This method sets the current winning point value.
	 * @param winningPoints - accepts an integer datatype.
	 */
	public void setWinningPoints(int winningPoints) {
		this.winningPoints = winningPoints;
	}

	/**
	 * This method sets the current loser value.
	 * @param loser - accepts a string datatype.
	 */
	public void setLoser(String loser) {
		this.loser = loser;
	}

	/**
	 * This method sets the current losing point value.
	 * @param losingPoints - accepts an integer datatype.
	 */
	public void setLosingPoints(int losingPoints) {
		this.losingPoints = losingPoints;
	}

	/**
	 * This method sets the current mvp value.
	 * @param mvp - accepts a string datatype.
	 */
	public void setMvp(String mvp) {
		this.mvp = mvp;
	}

	/**
	 * This method sets the current stadium value.
	 * @param stadium - accepts a string datatype.
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	/**
	 * This method sets the current city value.
	 * @param city - accepts a string datatype.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * This method sets the current state value.
	 * @param state - accepts a string datatype.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * This method sets the current point difference value.
	 * @param pointDifference - accepts an integer datatype.
	 */
	public void setPointDifference(int pointDifference) {
		this.pointDifference = pointDifference;
	}

	/**
	 *This method sets the natural sort order of the dataset.
	 */
	@Override
	public int compareTo(Superbowl e1) {
		return date.compareTo(e1.getDate());
	}

}
