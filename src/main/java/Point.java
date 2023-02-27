/**
 * Simple point object that contains x and y coordinates of a point in 2D space.
 * The coordinates are in Float format.
 * @author Mia Kallio
 *
 */
public class Point {
	/**
	 * Coordinates of the Point.
	 */
	private float x,y;
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
	 * @return String representation of this Point.
	 */
	public String toString() {
		return ("(" + x + "," + y + ")");
	}
	/**
	 * Creates a Point from a String containing the coordinates separated by a comma (,).
	 * @param xy_Str the String containing the coordinates.
	 */
	public Point(String xy_Str) {
		String[] xySeparated = xy_Str.split(",");
		x = Float.parseFloat(xySeparated[0]);
		y = Float.parseFloat(xySeparated[1]);
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
