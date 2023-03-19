/**
 * @author Mia Kallio
 */
import org.junit.jupiter.api.Test;

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
/*	
	@Test
	void testWhereIsIntersectsInPolyPoint() {
		 
		var polyPoints = new LinkedList<Point>();
		polyPoints.add(new Point("0,0"));
		polyPoints.add(new Point("0,4"));
		polyPoints.add(new Point("2,2"));
		polyPoints.add(new Point("4,4"));
		polyPoints.add(new Point("4,1"));
		polyPoints.add(new Point("5,0"));
		Polygon testPolygon = new Polygon(polyPoints);
		
		assertEquals(Polygon.INSIDE, testPolygon.whereIs(new Point("1,2")));
		assertEquals(Polygon.OUTSIDE, testPolygon.whereIs(new Point("-2,1")));
		assertEquals(Polygon.ON_BORDER, testPolygon.whereIs(new Point("2,0")));		
	}
*/
}
