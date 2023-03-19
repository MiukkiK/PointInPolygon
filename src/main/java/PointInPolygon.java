/** 
 * Class for finding out where given points are in relation to a polygon given in points.
 * Points are given either in text files and a target result file, or as Polygon and Points that are to be tested.
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
