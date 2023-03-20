/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestFileHandler {

	@Test
	void testfileAsString() {
		
		String assertString = "This is the test file contents (1 2 3)";

		assertEquals(assertString, FileHandler.fileAsString("src\\test\\resources\\fileasstringtest.txt"));
	}

	@Test
	void testWriteResults() {
		String testFileTarget = "src\\test\\resources\\writetest.txt";
		String testString = "This is a test string 1 2 3";

		FileHandler.writeResults(testString, testFileTarget);
		
		assertEquals(testString, FileHandler.fileAsString(testFileTarget));
	}
}
