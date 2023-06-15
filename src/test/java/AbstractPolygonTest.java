import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Abstract test class for fringe cases of the Polygon.whereIs() method.
 * Does not use Files in testing by default.
 *
 * @author Mia Kallio
 */
public abstract class AbstractPolygonTest {
	
	Polygon getPolygon(Point...points) {
		return new Polygon(points);
	}
	
	Point[] getPoints(Point...points) {
		return points;
	}

	Polygon.Position[] getResults(Polygon polygon, Point[] points) {
		return polygon.generateResults(points);
	}
	
	void runTest(Polygon polygon, Point[] points, Polygon.Position[] asserts) {
		
		assertEquals(asserts.length, points.length, "runTest() Point array length does not match assert array length.");
		
		Polygon.Position[] results = getResults(polygon, points);

		assertEquals(asserts.length, results.length, "getResults() returned different length array in runTest().");

		for (int i=0; i<asserts.length; i++) {
			assertEquals(asserts[i], results[i], "Problem with assertion index " + i);
		}
	}
	
	@Test
	void testWhereIsTriangle() {
		runTest(getPolygon(new Point(0,0), new Point(0,4), new Point(4,0)),
				getPoints(new Point(4,0), new Point(1,1), new Point(2,-2)),
				new Polygon.Position[] {Polygon.Position.ON_BORDER, Polygon.Position.INSIDE, Polygon.Position.OUTSIDE});
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		runTest(getPolygon(new Point(0,0), new Point(2,0), new Point(4,0), new Point(0,4), new Point(0,2)), 
				getPoints(new Point(3,0), new Point(0,1), new Point(-2,0)), 
				new Polygon.Position[] {Polygon.Position.ON_BORDER, Polygon.Position.ON_BORDER, Polygon.Position.OUTSIDE});
	}
	
	@Test
	void testWhereIsMShape() {
		runTest(getPolygon(new Point(0,0), new Point(0,4), new Point(2,2), new Point(4,4), new Point(4,0)), 
				getPoints(new Point(3,3), new Point(2,1), new Point(-1,4)), 
				new Polygon.Position[] {Polygon.Position.ON_BORDER, Polygon.Position.INSIDE, Polygon.Position.OUTSIDE});
	}
}