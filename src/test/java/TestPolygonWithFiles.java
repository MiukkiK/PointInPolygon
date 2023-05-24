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
	
	Polygon.Position[] getResults(Polygon.Position...results) {
		
		String writeString = "";
		for (Polygon.Position result : results) {
			writeString = writeString + result.toString() + "\n";
		}
		FileHandler.writeToFile(TESTFILE, writeString);
 		return super.getResults(FileHandler.readResultsFromFile(TESTFILE));
	}

}
