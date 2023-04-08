import java.util.LinkedList;
/**
 * A polygon object. Consists of the Points of the Polygon.
 * 
 * @author Mia Kallio
 */
public class Polygon {
	// Strings of results, modify here if you wish to change language for example.
	static String INSIDE = "inside";
	static String OUTSIDE = "outside";
	static String ON_BORDER = "on the border";
		
	/**
	 * An array of Points in the Polygon.
	 */
	Point[] points;
	
	/**
	 * a LinkedList of Points of the Polygon for the search function.
	 */
	LinkedList<Point> pointList;
	
	/**
	 * Creates a Polygon from an array of Points.
	 * 
	 * @param givenPoints the given array of Points.
	 */	
	public Polygon (Point[] givenPoints) {
			points = givenPoints;
			pointList = new LinkedList<Point>();
			for (Point point : points) {
				pointList.add(point);
			}
	}

	/**
	 * @return String representation of the Points of this Polygon.
	 */
	public String toString() {
		String result = "";
		int i = 0;
		while (i < pointList.size()) {
			result = result + pointList.get(i).toString() + " ";
			i++;
		}
		return result.strip();
	}
	/**
	 * A method to check where the given Point is in relation to the Polygon.
	 * 
	 * @param p the given Point.
	 * @return the result in String format.
	 */
	public String whereIs(Point p) {
		Point a, b, c; // line end points
		float k, solveX; // solution variables for hard solving the intersect point		
		int i = 0;
		int intersects = 0;
		int size = pointList.size();
		
		a = pointList.get(0);
		b = pointList.get((1)%size);
		// make sure first end point isn't on the solution line to avoid double dipping later
		while ((a.getY() == p.getY()) && (a.getX() > p.getX())) {
			pointList.addFirst(pointList.pollLast()); // rotate list 1 step back
			a = pointList.get(0);
			b = pointList.get((1)%size);
		}
		while(i < size) {
			
			a = pointList.get(i);
			b = pointList.get((i+1)%size);
			
			//if line is completely right of point, the calculation is more trivial
			if ((a.getX() > p.getX()) && (b.getX() > p.getX())) {
				while (b.getY() == p.getY() && b.getX() > p.getX()) {
					c = b;	
					i++;
					b = pointList.get((i+1)%size); // ignore end points on the point solution line
					 if((b.getY() == c.getY()) && (b.getX() < p.getX())) {
						return ON_BORDER; //straight horizontal line
					 }			
				}
				//if line is not entirely above or below solution line, it intersects
				if (!((a.getY() < p.getY()) && (b.getY() < p.getY()) || 
						(b.getY() > p.getY()) && (a.getY() > p.getY()))) {
					intersects++;
				}
			}
			//exclude lines completely left of the point
			else if (!((a.getX() < p.getX()) && (b.getX() < p.getX()))) {
				
				// exclude lines fully above or below point
				if (!((a.getY() < p.getY()) && (b.getY() < p.getY()) || 
				   	  (b.getY() > p.getY()) && (a.getY() > p.getY()))) {
					if (a.getX() == b.getX()) {
						return ON_BORDER; //straight vertical line
					}
					if(a.getY() == b.getY()) {
						return ON_BORDER; //straight horizontal line
					}
					//if all else fails, hard solve if intersect point is left of solution line
					k = (a.getY()-b.getY()) / (a.getX() - b.getX());
					/*  Solve X from  (y-y1) = k(x-x1)
					 *  x1, y1 is a point on the line, insert aX and aY
					 *  (y-aY)/k = x-aX
					 *  x = (y-aY)/k + aX
					 */
					solveX = ((p.getY()-a.getY())/k) + a.getX();
					if (solveX == p.getX()) {
						return ON_BORDER;
					} 
					else if (solveX > p.getX()) {
						intersects++;
					}
				}
			}
			i++;
		}

		if (intersects % 2 == 0) {
			return OUTSIDE;
		}
		else {
			return INSIDE;
		}
	}
	/**
	 * Generates whereIs() test results in a String for the given array of Points.
	 * @param points Array of Points to test
	 * @return Results in String format
	 */
	public String generateResults(Point[] points) {
		String resultString = "Results for polygon:\n" + this.toString() + "\n\n";
		for (Point point : points) {
			resultString = resultString + point.toString() + ": " + this.whereIs(point) + "\n";
		}
		return resultString;
	}
	
}
