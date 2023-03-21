import org.junit.jupiter.api.Test;

/**
 * Abstract test class for fringe cases of the Polygon.whereIs() method.
 *
 * @author Mia Kallio
 */
public abstract class AbstractPolygonTest {
	
	Polygon polygon;
	Point[] points;
	String assertString; 
	
	
	public Polygon getPolygon(String source) {
		return new Polygon(Point.getPointsFromString(FileHandler.fileAsString(source)));
	}
	
	public Point[] getPoints(String source) {
		return Point.getPointsFromString(FileHandler.fileAsString(source));
	}

	public String getResults(Polygon polygon, Point[] points) {
		return polygon.generateResults(points);
	}

	@Test
	abstract void testWhereIsTriangle();
	
	@Test
	abstract void testWhereIsDoubleJointedTriangle();
	
	@Test
	abstract void testWhereIsMShape();

}
