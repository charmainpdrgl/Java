package superbowl;

import java.util.Comparator;


public class AttendanceCompare implements Comparator<Superbowl>{
	public static Fields field;
	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		return Integer.compare(o1.getAttendance(), o2.getAttendance());
	}

}
