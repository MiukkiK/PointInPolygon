import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPolygonWithFiles extends AbstractPolygonTest {

	@Test
	void testWhereIsTriangle() {
		polygon = getPolygon("src\\test\\resources\\triangle.txt");
		points = getPoints("src\\test\\resources\\triangle_testpoints.txt");
		String assertString = FileHandler.fileAsString("src\\test\\resources\\triangle_assertresults.txt"); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	@Test
	void testWhereIsDoubleJointedTriangle() {
		polygon = getPolygon("src\\test\\resources\\doublejointedtriangle.txt");
		points = getPoints("src\\test\\resources\\doublejointedtriangle_testpoints.txt");
		String assertString = FileHandler.fileAsString("src\\test\\resources\\doublejointedtriangle_assertresults.txt"); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
	
	
	@Test
	void testWhereIsMShape() {
		polygon = getPolygon("src\\test\\resources\\mshape.txt");
		points = getPoints("src\\test\\resources\\mshape_testpoints.txt");
		String assertString = FileHandler.fileAsString("src\\test\\resources\\mshape_assertresults.txt"); 
		
		assertEquals(assertString, getResults(polygon, points));
	}
}
