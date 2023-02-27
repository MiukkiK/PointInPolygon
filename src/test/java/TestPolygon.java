/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class TestPolygon {

	@Test
	void testPolygonConstructor() {
		Point pointA = new Point("0,0");
		Point pointB = new Point("0,1");
		Point pointC = new Point("1,0");
		var points = new LinkedList<Point>();
		points.add(pointA);
		points.add(pointB);
		points.add(pointC);
		Polygon testPoly = new Polygon(points);
		
		assertTrue(testPoly.toString().equals(pointA.toString() + " " + pointB.toString() + " " + pointC.toString()));
	}

	@Test
	void testWhereIsBasic() {
		// result strings, ensure they are same as in Polygon class
		
		var polyPoints = new LinkedList<Point>();
		polyPoints.add(new Point("0,0"));
		polyPoints.add(new Point("0,4"));
		polyPoints.add(new Point("4,0"));
		Polygon testPolygon = new Polygon(polyPoints);
		
		assertEquals(Polygon.INSIDE, testPolygon.whereIs(new Point("1,1")));
		assertEquals(Polygon.OUTSIDE, testPolygon.whereIs(new Point("3,5")));
		assertEquals(Polygon.ON_BORDER, testPolygon.whereIs(new Point("2,2")));
	}

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

	@Test
	void testWhereIsSolutionGoesThroughPolyPoint() {
		 
		var polyPoints = new LinkedList<Point>();
		polyPoints.add(new Point("0,0"));
		polyPoints.add(new Point("0,2"));
		polyPoints.add(new Point("0,4"));
		polyPoints.add(new Point("4,0"));
		polyPoints.add(new Point("2,0"));
		Polygon testPolygon = new Polygon(polyPoints);
		
		assertEquals(Polygon.OUTSIDE, testPolygon.whereIs(new Point("-2,0")));
		assertEquals(Polygon.ON_BORDER, testPolygon.whereIs(new Point("0,3")));
	}
	
}
