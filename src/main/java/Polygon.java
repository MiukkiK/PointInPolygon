import java.util.LinkedList;
/**
 * A polygon object represented in a LinkedList of Points.
 * @author Mia Kallio
 */
public class Polygon {
	// Strings of results, modify here if you wish to change language for example.
	public static String INSIDE = "inside";
	public static String OUTSIDE = "outside";
	public static String ON_BORDER = "on the border";
		
	/**
	 * The LinkedList of Points the Polygon is made out of.
	 */
	LinkedList<Point> points;
	/**
	 * Creates a Polygon from a LinkedList of Points.
	 * @param givenPoints the given LinkedList of Points.
	 */
	
	public Polygon (LinkedList<Point> givenPoints) {			
		points = givenPoints;		
	}
	/**
	 * @return String representation of the Points of this Polygon.
	 */
	public String toString() {
		String result = "";
		int i = 0;
		while (i < points.size()) {
			result = result + points.get(i).toString() + " ";
			i++;
		}
		return result.strip();
	}
	/**
	 * A method to check where the given Point is in relation to the Polygon.
	 * @param p the given Point.
	 * @return the result in String format.
	 */
	public String whereIs(Point p) {
		Point a, b, c; // line end points
		float k, solveX; // solution variables for hard solving the intersect point		
		int i = 0;
		int intersects = 0;
		int size = points.size();
		
		a = points.get(0);
		b = points.get((1)%size);
		// make sure first end point isn't on the solution line to avoid double dipping later
		while ((a.getY() == p.getY()) && (a.getX() > p.getX())) {
			// Verbose
			// System.out.println("endpoint is on the solution line, rotating..");
			points.addFirst(points.pollLast()); // rotate list 1 step back
			a = points.get(0);
			b = points.get((1)%size);
		}
		while(i < size) {
			
			a = points.get(i);
			b = points.get((i+1)%size);
			
			//if line is completely right of point, the calculation is more trivial
			if ((a.getX() > p.getX()) && (b.getX() > p.getX())) {
				while (b.getY() == p.getY() && b.getX() > p.getX()) {
					// Verbose
					// System.out.println(b.toString() + " is on the solution line of " + p.toString() + " and was ignored.");
					c = b;	
					i++;
					b = points.get((i+1)%size); // ignore end points on the point solution line
					 if((b.getY() == c.getY()) && (b.getX() < p.getX())) {
						// Verbose
						// System.out.println(c.toString() + "-" + b.toString() + " goes through " + p.toString() + ". The point is on border.");
						return ON_BORDER; //straight horizontal line
					 }			
				}
				//if line is not entirely above or below solution line, it intersects
				if (!((a.getY() < p.getY()) && (b.getY() < p.getY()) || 
						(b.getY() > p.getY()) && (a.getY() > p.getY()))) {
					// Verbose
					// System.out.println(a.toString() + "-" + b.toString() + " is on the right side of " + p.toString() + " and intersects.");
					intersects++;
				}
			}
			//exclude lines completely left of the point
			else if (!((a.getX() < p.getX()) && (b.getX() < p.getX()))) {
				
				// exclude lines fully above or below point
				if (!((a.getY() < p.getY()) && (b.getY() < p.getY()) || 
				   	  (b.getY() > p.getY()) && (a.getY() > p.getY()))) {
					if (a.getX() == b.getX()) {
						// Verbose
						// System.out.println(a.toString() + "-" + b.toString() + " goes through " + p.toString() + " and is vertical.");
						return ON_BORDER; //straight vertical line
					}
					if(a.getY() == b.getY()) {
						// Verbose
						// System.out.println(a.toString() + "-" + b.toString() + " goes through " + p.toString() + " and is horizontal.");
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
						// Verbose
						// System.out.println(a.toString() + "-" + b.toString() + " was hard solved to contain " + p.toString() + " and is on border.");
						return ON_BORDER;
					} 
					else if (solveX > p.getX()) {
						// Verbose
						// System.out.println(a.toString() + "-" + b.toString() + " is near " + p.toString() + " and was hard solved to intersect at (" + solveX + "," + p.getY() + ").");
						intersects++;
					}
				}
			}
			i++;
		}
		// Verbose
		// System.out.println("i was iterated to " + i + ", polygon size was " + size + ".");
		if (intersects % 2 == 0) {
			// Verbose
			// System.out.println(p.toString() + ": " + intersects + " intersections, is outside.");
			return OUTSIDE;
		}
		else {
			// Verbose
			// System.out.println(p.toString() + ": " + intersects + " intersections, is inside.");
			return INSIDE;
		}
	}
}
