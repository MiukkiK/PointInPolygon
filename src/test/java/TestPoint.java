/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestPoint {

	@Test
	void testPointConstructors() {
		float testFloatX = 5;
		float testFloatY = -3;
		Point testPoint1 = new Point(testFloatX, testFloatY);
		Point testPoint2 = new Point("5,-3");
		assertEquals(testPoint1.toString(), testPoint2.toString());
	}
	
	@Test
	void testGetPointsFromString() {
		Point pointA = new Point("1,1");
		Point pointB = new Point("2,2");
		Point pointC = new Point("3,3");
		String assertPointString = pointA.toString() + pointB.toString() + pointC.toString();
		String testPointString = "";
		Point[] testPoints = Point.getPointsFromString(assertPointString);
		for (Point point : testPoints) {
			testPointString = testPointString + point.toString();
		}
		assertEquals(assertPointString, testPointString);
	}
	
}
