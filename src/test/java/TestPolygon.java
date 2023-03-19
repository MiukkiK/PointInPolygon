/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestPolygon {

	@Test
	void testPolygonConstructor() {
		
		Point pointA = new Point("0,0");
		Point pointB = new Point("0,1");
		Point pointC = new Point("1,0");
		
		Polygon testPoly = new Polygon(new Point[] {pointA, pointB, pointC});
		
		String assertString = pointA.toString() + " " + pointB.toString() + " " + pointC.toString();

		assertEquals(assertString, testPoly.toString());
	}
}
