import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPolygonWithoutFiles extends AbstractPolygonTest {

	String[] results;
	
	 String makeAssertString(Polygon polygon, Point[] points, String[] results) {
		String assertString = "Results for polygon:\n" + polygon + "\n\n";
		for (int i=0; i < points.length; i++) {
			assertString = assertString + points[i] + ": " + results[i] + "\n";
		}
		return assertString;
	}		
	
	@Test
	void testWhereIsTriangle() {
		polygon = getPolygon("(0,0) (0,4) (4,0)");
		points = getPoints("(4,0) (1,1) (2,-2)");
		results = new String[] {Polygon.ON_BORDER, Polygon.INSIDE, Polygon.OUTSIDE};
		String assertString = makeAssertString(polygon, points, results); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		polygon = getPolygon("(0,0) (2,0) (4,0) (0,4) (0,2)");
		points = getPoints("(3,0) (0,1) (-2,0)");
		results = new String[] {Polygon.ON_BORDER, Polygon.ON_BORDER, Polygon.OUTSIDE};
		String assertString = makeAssertString(polygon, points, results); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	
	@Test
	void testWhereIsMShape() {
		polygon = getPolygon("(0,0) (0,4) (2,2) (4,4) (4,0)");
		points = getPoints("(3,3) (2,1) (-1,4)");
		results = new String[] {Polygon.ON_BORDER, Polygon.INSIDE, Polygon.OUTSIDE};
		String assertString = makeAssertString(polygon, points, results); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
}
