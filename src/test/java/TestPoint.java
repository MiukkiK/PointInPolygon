/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPoint {

	@Test
	void PointConstructors() {
		float testFloatX = 5;
		float testFloatY = -3;
		Point testPoint1 = new Point(testFloatX, testFloatY);
		Point testPoint2 = new Point("5,-3");
		assertTrue(testPoint1.toString().equals(testPoint2.toString()));
	}
}
