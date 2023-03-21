/** 
 * Class for finding out where given points are in relation to a polygon given in points.
 * Input is given either as points of polygon and points to be tested, or as file locations.
 *
 * Syntax: {"(x0,b0) (x1,y1) .. (xn,yn)", "(i0,j0) (i1, j1) .. (in,jn)"} without files,
 * 		{"src\\folder\\polypoints.txt", "src\\folder\\testpoints.txt", "src\\folder\\results.txt"} with files.
 * 
 * Files need to exist beforehand. Result file's contents will be overwritten.
 * 
 * @author Mia Kallio
 */
public class PointInPolygon {

	public static void main(String[] args) {
		Polygon polygon = new Polygon(Point.getPointsFromString(FileHandler.fileAsString(args[0])));
		Point[] points = Point.getPointsFromString(FileHandler.fileAsString(args[1]));

		String target = "none";
		if (args.length > 2) target = args[2];

		String results = polygon.generateResults(points);
		FileHandler.writeResults(results, target);
	}
}
