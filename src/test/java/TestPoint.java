import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for testing the methods of the Point class.
 * 
 * @author Mia Kallio
 */
class TestPoint {

	@Test
	void testPointConstructors() {
		float testFloatX = 5;
		float testFloatY = -3;
		Point testPoint1 = new Point(testFloatX, testFloatY);
		Point testPoint2 = new Point("5,-3");
		assertEquals(testPoint1.getX(), testPoint2.getX(), "Mismatch: X coordinate of Point constructor not equal");
		assertEquals(testPoint1.getY(), testPoint2.getY(), "Mismatch: Y coordinate of Point constructor not equal");
	}
	
	@Test
	void testGetPointsFromString() {
		Point pointA = new Point(1,1);
		Point pointB = new Point(2,2);
		Point pointC = new Point(3,3);
		Point[] assertPoints = new Point[] {pointA, pointB, pointC};
		Point[] testPoints = Point.getPointsFromString(pointA.toString() + pointB.toString() + pointC.toString());
		for (int i=0; i<assertPoints.length; i++) {
			assertEquals(assertPoints[i].getX(), testPoints[i].getX(), "Mismatch: X coordinate in getPointsFromString test, position " + i );
			assertEquals(assertPoints[i].getY(), testPoints[i].getY(), "Mismatch: Y coordinate in getPointsFromString test, position " + i );
		}		
	}
	
}
