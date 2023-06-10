import java.util.LinkedList;
import java.util.Scanner;

/**
 * Simple point object that contains x and y coordinates of a point in 2D space.
 * The coordinates are in Float format.
 * 
 * @author Mia Kallio
 */
public class Point {
	/**
	 * Coordinate of the Point.
	 */
	private float x,y;
	
	/**
	 * Static method for creating an array of Points from a string containing multiple point inputs.
	 * Input should be in the format of "(a,b) (c,d)\n .. (e,f)"
	 * @param string Input String of points.
	 * @return an array of Points.
	 */
	public static Point[] getPointsFromString(String string) {
		LinkedList<Point> pointList = new LinkedList<Point>();
				
		try (Scanner scanner = new Scanner(string).useDelimiter("([()]|\\s)+")) {
			while (scanner.hasNext()) {
				pointList.add(new Point(scanner.next()));
				}
			scanner.close();
		} 
		Point[] points = new Point[pointList.size()];
		return pointList.toArray(points);
	}
	/**
	 * Creates a Point from the coordinates in Float format.
	 * @param givenX the x coordinate of the Point.
	 * @param givenY the y coordinate of the Point.
	 */
	public Point(float givenX, float givenY) {
		x = givenX;
		y = givenY;
	}
	
	/**
	 * Creates a Point from a String containing the coordinates separated by a comma ("a,b").
	 * @param xy_Str the String containing the coordinates.
	 */
	public Point(String xy_Str) {
		String[] xySeparated = xy_Str.split(",");
		x = Float.parseFloat(xySeparated[0]);
		y = Float.parseFloat(xySeparated[1]);
	}
	
	/**
	 * @return String representation of this Point.
	 */
	public String toString() {
		return ("(" + x + "," + y + ")");
	}

	/**
	 * Returns the x coordinate of this Point.
	 * @return the x coordinate.
	 */
	public float getX() {
		return x;
	}
	/**
	 * Returns the y coordinate of this Point.
	 * @return the y coordinate.
	 */
	public float getY() {
		return y;
	}
}
