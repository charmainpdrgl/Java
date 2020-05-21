package superbowl;
import java.util.Comparator;
public class StateCompare implements Comparator<Superbowl>{

	@Override
	public int compare(Superbowl o1, Superbowl o2) {
		return o1.getState().compareTo(o2.getState());
	}

}
