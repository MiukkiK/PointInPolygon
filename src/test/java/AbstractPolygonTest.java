import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Abstract test class for fringe cases of the Polygon.whereIs() method.
 * Does not use Files in testing by default.
 *
 * @author Mia Kallio
 */
public abstract class AbstractPolygonTest {
	
	Polygon getPolygon(String source) {
		String pointString = "not initialized";
		switch (source) {
		case "triangle": 
			pointString = "(0,0) (0,4) (4,0)";
			break;
		case "doublejoint": 
			pointString = "(0,0) (2,0) (4,0) (0,4) (0,2)";
			break;
		case "mshape": 
			pointString = "(0,0) (0,4) (2,2) (4,4) (4,0)";
			break;
		}
		return new Polygon(Point.getPointsFromString(pointString));
	}
	
	Point[] getPoints(String source) {
		String pointString = "not initialized";
		switch (source) {
		case "triangle": 
			pointString = "(4,0) (1,1) (2,-2)";
			break;
		case "doublejoint": 
			pointString = "(3,0) (0,1) (-2,0)";
			break;
		case "mshape": 
			pointString = "(3,3) (2,1) (-1,4)";
			break;
		}
		return Point.getPointsFromString(pointString);
	}

	String[] getResults(String source) {
		String pointString = "not initialized";
		switch (source) {
			case "triangle": 
				pointString = Polygon.ON_BORDER + "," + Polygon.INSIDE + "," + Polygon.OUTSIDE;
				break;
			case "doublejoint": 
				pointString = Polygon.ON_BORDER + "," + Polygon.ON_BORDER + "," + Polygon.OUTSIDE;
				break;
			case "mshape": 
				pointString = Polygon.ON_BORDER + "," + Polygon.INSIDE + "," + Polygon.OUTSIDE;
				break;
		}
		String[] results = pointString.split(",");
		return results;
	}
	
	void runTest(Polygon polygon, Point[] points, String[] asserts) {
		for (int i=0; i<asserts.length; i++) {
			System.out.println("Testing with polygon " + polygon.toString() + ", assertion " + asserts[i]);
			assertEquals(asserts[i], polygon.whereIs(points[i]), "Problem with assertion index " + i);
		}
	}
	
	@Test
	void testWhereIsTriangle() {
		runTest(getPolygon("triangle"), getPoints("triangle"), getResults("triangle"));
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		runTest(getPolygon("doublejoint"), getPoints("doublejoint"), getResults("doublejoint"));
	}
	
	@Test
	void testWhereIsMShape() {
		runTest(getPolygon("mshape"), getPoints("mshape"), getResults("mshape"));
	}
}