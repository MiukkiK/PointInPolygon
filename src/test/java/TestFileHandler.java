import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for testing the methods of the FileHandler class.
 * 
 * @author Mia Kallio
 */
class TestFileHandler {
	final String TESTFILE = "src\\test\\temp\\test.txt";
	@Test
	void testFileAsString() {
		
		String assertString = "This is the test file contents (1 2 3)";

		assertEquals(assertString, FileHandler.fileAsString("src\\test\\resources\\fileasstringtest.txt"));
	}

	@Test
	void testReadResultsFromFile() {
		Polygon.Position[] assertPositions = new Polygon.Position[] {Polygon.Position.INSIDE, Polygon.Position.OUTSIDE, Polygon.Position.ON_BORDER};
		Polygon.Position[] filePositions = FileHandler.readResultsFromFile("src\\test\\resources\\readresultsfromfiletest.txt");

		for (int i=0; i < assertPositions.length; i++) {
			assertEquals(assertPositions[i], filePositions[i], "Assert mismatch at array index " + i);
		}
		
	}
	
	@Test
	void testWriteToFile() {
		String testString = "This is a test string 1 2 3";
		FileHandler.writeToFile(TESTFILE, testString);	
		assertEquals(testString, FileHandler.fileAsString(TESTFILE));
	}
	
	@Test
	void testWriteArrayWithPoints() {
		Point[] assertPoints = Point.getPointsFromString("(1,2) (3,4) (5,6)");
		FileHandler.writeArrayToFile(TESTFILE, assertPoints, " ");
		Point[] points = Point.getPointsFromString(FileHandler.fileAsString(TESTFILE));
		
		for (int i=0; i<assertPoints.length; i++) {
			assertEquals(assertPoints[i].toString(), points[i].toString(), "Mismatch in array position " + i);
		}
	}
	
	@Test
	void testWriteArrayWithPositions() {
		Polygon.Position[] assertResults = new Polygon.Position[] {Polygon.Position.ON_BORDER, Polygon.Position.OUTSIDE, Polygon.Position.INSIDE};
		FileHandler.writeArrayToFile(TESTFILE, assertResults, ",");
		Polygon.Position[] results = FileHandler.readResultsFromFile(TESTFILE);
		
		for (int i=0; i<assertResults.length; i++) {
			assertEquals(assertResults[i], results[i], "Mismatch in array position " + i);
		}
	}
	
	@Test
	void testFormulateResults() {
		Polygon polygon = new Polygon(Point.getPointsFromString("(0,0) (0,4) (4,4) (4,0)"));
		Point[] points = Point.getPointsFromString("(2,2) (5,5) (4,4)");
		Polygon.Position[] results = new Polygon.Position[] {Polygon.Position.INSIDE, Polygon.Position.OUTSIDE, Polygon.Position.ON_BORDER};

		assertEquals(FileHandler.fileAsString("src\\test\\resources\\formulateresultstest.txt"), FileHandler.formulateResults(polygon, points, results));
	}
}
