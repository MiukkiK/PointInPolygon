import java.util.LinkedList;
/** 
 * Program to find out where given points are in relation to a polygon given in points.
 * Points are given in files and results are written in a result file.
 * @author Mia Kallio
 */
public class PointInPolygon {
	// Define file locations
	static String POINTSOURCE = "src\\main\\resources\\pisteet.txt";
	static String POLYSOURCE = "src\\main\\resources\\polygoni.txt";
	static String RESULTTARGET = "src\\main\\resources\\tulokset.txt";

	public static void main(String[] args) {
		FileHandler fileHandler = new FileHandler();
		LinkedList<Point> pointList = fileHandler.readPoints(POINTSOURCE);
		Polygon polygon = new Polygon (fileHandler.readPoints(POLYSOURCE));
		LinkedList<String> results = new LinkedList<String>();
		
		int i = 0;
		while (i < pointList.size()) {
			results.add(polygon.whereIs(pointList.get(i)));
			i++;
		}
		
		fileHandler.writeResults(pointList, polygon, results, RESULTTARGET);
		
		System.out.println("Njet problem, normal Katastrof");
	}

}
