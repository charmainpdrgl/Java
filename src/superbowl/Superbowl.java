package superbowl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

	public Superbowl(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getAttendance() {
		return attendance;
	}

	public String getWinner() {
		return winner;
	}

	public int getWinningPoints() {
		return winningPoints;
	}

	public String getLoser() {
		return loser;
	}

	public int getLosingPoints() {
		return losingPoints;
	}

	public String getMvp() {
		return mvp;
	}

	public String getStadium() {
		return stadium;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getPointDifference() {
		return pointDifference;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public void setWinningPoints(int winningPoints) {
		this.winningPoints = winningPoints;
	}

	public void setLoser(String loser) {
		this.loser = loser;
	}

	public void setLosingPoints(int losingPoints) {
		this.losingPoints = losingPoints;
	}

	public void setMvp(String mvp) {
		this.mvp = mvp;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPointDifference(int pointDifference) {
		this.pointDifference = pointDifference;
	}

	/*public String toString(Superbowl event) {
		StringBuilder build = new StringBuilder();

		if (this.date.equals(event.getDate())) {
			build.append(date.toString());
		}

		if (this.attendance == event.getAttendance()) {
			build.append(Integer.toString(attendance));
		}

		if (this.winner.equals(event.getWinner())) {
			build.append(winner.toString());
		}

		if (this.winningPoints == event.getWinningPoints()) {
			build.append(Integer.toString(winningPoints));
		}

		if (this.loser.equals(event.getLoser())) {
			build.append(loser.toString());
		}

		if (this.losingPoints == event.getLosingPoints()) {
			build.append(Integer.toString(losingPoints));
		}

		if (this.mvp.equals(event.getMvp())) {
			build.append(mvp.toString());
		}

		if (this.stadium.equals(event.getStadium())) {
			build.append(stadium.toString());
		}

		if (this.city.equals(event.getCity())) {
			build.append(city.toString());
		}

		if (this.state.equals(event.getState())) {
			build.append(state.toString());
		}

		if (this.pointDifference == event.getPointDifference()) {
			build.append(Integer.toString(pointDifference));
		}

		//System.out.println(build.toString());
		return build.toString();
	}*/

	@Override
	public int compareTo(Superbowl e1) {
		// setting up the natural sort order
		return date.compareTo(e1.getDate());
	}

}
