package superbowl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	@Test
	void minAttendanceTest() {
		ArrayList<Superbowl> numbers = new ArrayList<Superbowl>();
		numbers.add(5, null);
		numbers.add(60, null);
		numbers.add(70, null);
		numbers.add(5, null);
		numbers.add(52, null);
		numbers.add(11, null);
		numbers.add(12, null);
		numbers.add(8, null);
		numbers.add(19, null);
		numbers.add(20, null);
		int actual = Utilities.findMinimumAttendance(numbers);
		int expected = 5;
		assertEquals(expected, actual);
	}
	
	@Test
	void maxAttendanceTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void minScoreTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void maxScoreTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void averagePointTest() {
		fail("Not yet implemented");
	}

}
