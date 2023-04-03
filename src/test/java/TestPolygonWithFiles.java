import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for fringe cases of the Polygon.whereIs() method.
 * This variation tests using File reads and writes.
 * 
 * @author Mia Kallio
 */
public class TestPolygonWithFiles extends AbstractPolygonTest {

	@Test
	void testWhereIsTriangle() {
		Polygon polygon = getPolygon("src\\test\\resources\\triangle.txt");
		Point[] points = getPoints("src\\test\\resources\\triangle_testpoints.txt");
		String assertString = FileHandler.fileAsString("src\\test\\resources\\triangle_assertresults.txt"); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		Polygon polygon = getPolygon("src\\test\\resources\\doublejointedtriangle.txt");
		Point[] points = getPoints("src\\test\\resources\\doublejointedtriangle_testpoints.txt");
		String assertString = FileHandler.fileAsString("src\\test\\resources\\doublejointedtriangle_assertresults.txt"); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	
	@Test
	void testWhereIsMShape() {
		Polygon polygon = getPolygon("src\\test\\resources\\mshape.txt");
		Point[] points = getPoints("src\\test\\resources\\mshape_testpoints.txt");
		String assertString = FileHandler.fileAsString("src\\test\\resources\\mshape_assertresults.txt"); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
}
