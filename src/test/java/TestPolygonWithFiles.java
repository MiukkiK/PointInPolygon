/**
 * Test class for fringe cases of the Polygon.whereIs() method.
 * This variation tests using File reads and writes.
 * 
 * @author Mia Kallio
 */
public class TestPolygonWithFiles extends AbstractPolygonTest {
	final String TESTFILE = "src\\test\\temp\\test.txt";
	Polygon getPolygon(Point...points) {
		FileHandler.writeArrayToFile(TESTFILE, points, " ");
		return super.getPolygon(Point.getPointsFromString(FileHandler.fileAsString(TESTFILE)));
	}
	
	Point[] getPoints(Point...points) {
		FileHandler.writeArrayToFile(TESTFILE, points, " ");
		return super.getPoints(Point.getPointsFromString(FileHandler.fileAsString(TESTFILE)));
	}
	
	Polygon.Position[] getResults(Polygon polygon, Point[] points) {
		
		var results = super.getResults(polygon, points);
		FileHandler.writeArrayToFile(TESTFILE, results, ",");
 		return FileHandler.readResultsFromFile(TESTFILE);
	}

}
