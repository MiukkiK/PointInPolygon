import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the PointInPolygon class. 
 * Currently only has test run lines for running the program with example inputs.
 * 
 * @author Mia Kallio
 */
class TestPointInPolygon {

	@Test
	void runWithoutFile() {
		PointInPolygon.main("(0,0) (4,0) (0,4)","((2,2) (1,1) (2,-2)", "src\\test\\temp\\test.txt");
		assertEquals(FileHandler.fileAsString("src\\test\\resources\\pointinpolygonwithoutfiletest.txt"),FileHandler.fileAsString("src\\test\\temp\\test.txt"));
	}

	@Test
	void runWithFile() {
	 	PointInPolygon.main("src\\test\\resources\\polygon.txt","src\\test\\resources\\points.txt","src\\test\\resources\\results.txt");
	 	assertEquals(FileHandler.fileAsString("src\\test\\resources\\pointinpolygonwithfiletest.txt"), FileHandler.fileAsString("src\\test\\resources\\results.txt"));
	}

}
