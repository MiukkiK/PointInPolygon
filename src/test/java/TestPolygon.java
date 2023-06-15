import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Polygon class. Tests the constructor method.
 * Additional tests are in the TestPolygonWithFiles and TestPolygonWithoutFiles classes.
 * 
 * @author Mia Kallio
 */
class TestPolygon {

	@Test
	void testPolygonConstructor() {
		
		Point pointA = new Point(0,0);
		Point pointB = new Point(0,1);
		Point pointC = new Point(1,0);
		
		Polygon testPoly = new Polygon(new Point[] {pointA, pointB, pointC});
		
		String assertString = pointA.toString() + " " + pointB.toString() + " " + pointC.toString();

		assertEquals(assertString, testPoly.toString());
	}
	
	@Test
	void testGenerateResults() {
		Polygon polygon = new Polygon(new Point[] {new Point("0,0"), new Point("0,4"), new Point("4,0")});
		Point[] testPoints = new Point[] {new Point("0,5"), new Point("1,1"), new Point("0,2")};
		Polygon.Position[] assertResults = new Polygon.Position[] {Polygon.Position.OUTSIDE, Polygon.Position.INSIDE, Polygon.Position.ON_BORDER};
		Polygon.Position[] results = polygon.generateResults(testPoints);
		
		assertEquals(assertResults.length, results.length, "generateResults() returned a different length array.");
		
		for (int i=0; i < results.length; i++) {
			assertEquals(assertResults[i], results[i], "Result mismatch at position " + i);
		}

	}
}
