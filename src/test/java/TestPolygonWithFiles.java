/**
 * Test class for fringe cases of the Polygon.whereIs() method.
 * This variation tests using File reads and writes.
 * 
 * @author Mia Kallio
 */
public class TestPolygonWithFiles extends AbstractPolygonTest {
	final String TESTFILE = "src\\test\\temp\\test.txt";
	Polygon getPolygon(Point...points) {
		String writeString = "";
		for (Point point : points) {
			writeString = writeString + point.toString();
		}
		FileHandler.writeToFile(TESTFILE, writeString);
		return super.getPolygon(Point.getPointsFromString(FileHandler.fileAsString(TESTFILE)));
	}
	
	Point[] getPoints(Point...points) {
		String writeString = "";
		for (Point point : points) {
			writeString = writeString + point.toString();
		}
		FileHandler.writeToFile(TESTFILE, writeString);	
		return super.getPoints(Point.getPointsFromString(FileHandler.fileAsString(TESTFILE)));
	}
	
	Polygon.Position[] getResults(Polygon polygon, Point[] points) {
		
		var results = super.getResults(polygon, points);
		String writeString = "";
		for (Polygon.Position result : results) {
			if (writeString != "") writeString = writeString + ",";
			writeString = writeString + result.toString();
		}
		FileHandler.writeToFile(TESTFILE, writeString);
 		return FileHandler.readResultsFromFile(TESTFILE);
	}

}
