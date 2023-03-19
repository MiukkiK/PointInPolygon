/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestFileHandler {

	@Test
	void testfileAsString() {
		Point pointA = new Point("1,1");
		Point pointB = new Point("2,3");
		Point pointC = new Point("4,5");
		
		String testPoints = FileHandler.fileAsString("src\\test\\resources\\fileasstringtest.txt");

		assertEquals((pointA + " " + pointB + " " + pointC), testPoints);
	}

	@Test
	void testWriteResults() {
		String testFileTarget = "src\\test\\resources\\writetest.txt";
		String testString = "This is a test string 1 2 3";

		FileHandler.writeResults(testString, testFileTarget);
		
		assertEquals(testString, FileHandler.fileAsString(testFileTarget));
	}
}
