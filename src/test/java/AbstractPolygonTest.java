import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Abstract test class for fringe cases of the Polygon.whereIs() method.
 * Does not use Files in testing by default.
 *
 * @author Mia Kallio
 */
public abstract class AbstractPolygonTest {
	
	public Polygon getPolygon(String source) {
		return new Polygon(Point.getPointsFromString(FileHandler.fileAsString(source)));
	}
	
	public Point[] getPoints(String source) {
		return Point.getPointsFromString(FileHandler.fileAsString(source));
	}

	public String getResults(Polygon polygon, Point[] points) {
		return polygon.generateResults(points);
	}
	
	String makeAssertString(Polygon polygon, Point[] points, String[] results) {
		String assertString = "Results for polygon:\n" + polygon + "\n\n";
		for (int i=0; i < points.length; i++) {
			assertString = assertString + points[i] + ": " + results[i] + "\n";
		}
		return assertString;
	}		
	
	@Test
	void testWhereIsTriangle() {
		Polygon polygon = getPolygon("(0,0) (0,4) (4,0)");
		Point[] points = getPoints("(4,0) (1,1) (2,-2)");
		String[] results = new String[] {Polygon.ON_BORDER, Polygon.INSIDE, Polygon.OUTSIDE};
		String assertString = makeAssertString(polygon, points, results); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		Polygon polygon = getPolygon("(0,0) (2,0) (4,0) (0,4) (0,2)");
		Point[] points = getPoints("(3,0) (0,1) (-2,0)");
		String[] results = new String[] {Polygon.ON_BORDER, Polygon.ON_BORDER, Polygon.OUTSIDE};
		String assertString = makeAssertString(polygon, points, results); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	@Test
	void testWhereIsMShape() {
		Polygon polygon = getPolygon("(0,0) (0,4) (2,2) (4,4) (4,0)");
		Point[] points = getPoints("(3,3) (2,1) (-1,4)");
		String[] results = new String[] {Polygon.ON_BORDER, Polygon.INSIDE, Polygon.OUTSIDE};
		String assertString = makeAssertString(polygon, points, results); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
}