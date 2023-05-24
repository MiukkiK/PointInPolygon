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

	Polygon.Position[] getResults(Polygon.Position...results) {
		return results;
	}
	
	void runTest(Polygon polygon, Point[] points, Polygon.Position[] asserts) {
		if (points.length != asserts.length) throw new ArrayIndexOutOfBoundsException("Point and assert Array lengths do not match. Point array length: " + points.length + ", assert array length: " + asserts.length); 
		for (int i=0; i<asserts.length; i++) {
			System.out.println("Testing with polygon " + polygon.toString() + ", assertion " + asserts[i]);
			assertEquals(asserts[i], polygon.whereIs(points[i]), "Problem with assertion index " + i);
		}
	}
	
	@Test
	void testWhereIsTriangle() {
		runTest(getPolygon(new Point(0,0), new Point(0,4), new Point(4,0)),
				getPoints(new Point(4,0), new Point(1,1), new Point(2,-2)),
				getResults(Polygon.Position.ON_BORDER, Polygon.Position.INSIDE, Polygon.Position.OUTSIDE));
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		runTest(getPolygon(new Point(0,0), new Point(2,0), new Point(4,0), new Point(0,4), new Point(0,2)), 
				getPoints(new Point(3,0), new Point(0,1), new Point(-2,0)), 
				getResults(Polygon.Position.ON_BORDER, Polygon.Position.ON_BORDER, Polygon.Position.OUTSIDE));
	}
	
	@Test
	void testWhereIsMShape() {
		runTest(getPolygon(new Point(0,0), new Point(0,4), new Point(2,2), new Point(4,4), new Point(4,0)), 
				getPoints(new Point(3,3), new Point(2,1), new Point(-1,4)), 
				getResults(Polygon.Position.ON_BORDER, Polygon.Position.INSIDE, Polygon.Position.OUTSIDE));
	}
}