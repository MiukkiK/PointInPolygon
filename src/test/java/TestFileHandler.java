import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for testing the methods of the FileHandler class.
 * 
 * @author Mia Kallio
 */
class TestFileHandler {

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
		String testFileTarget = "src\\test\\temp\\test.txt";
		String testString = "This is a test string 1 2 3";

		FileHandler.writeToFile(testFileTarget, testString);
		
		assertEquals(testString, FileHandler.fileAsString(testFileTarget));
	}
}
