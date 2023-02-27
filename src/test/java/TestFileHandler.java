/**
 * @author Mia Kallio
 */
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestFileHandler {

	@Test
	void testReadPoints() {
		Point testPoint1 = new Point("1,1");
		Point testPoint2 = new Point("2,3");
		Point testPoint3 = new Point("4,5");
		var fileHandler = new FileHandler();
		var testPoints = fileHandler.readPoints("src\\test\\resources\\fileHandlerTestFile1.txt");
		assertTrue(testPoint1.toString().equals(testPoints.get(0).toString()));
		assertTrue(testPoint2.toString().equals(testPoints.get(1).toString()));
		assertTrue(testPoint3.toString().equals(testPoints.get(2).toString()));
	}

	@Test
	void testWriteResults() {
		var fileHandler = new FileHandler();
		var testPoints = new LinkedList<Point>();
		var polyList = new LinkedList<Point>();
		var results = new LinkedList<String>();
		String testFileLocation = "src\\test\\resources\\writetest.txt";
		
		testPoints.add(new Point("1,1"));
		testPoints.add(new Point("2,2"));
		polyList.add(new Point("3,3"));
		polyList.add(new Point("4,4"));
		Polygon testPolygon = new Polygon(polyList);
		results.add("teststring1");
		results.add("teststring2");
		
		fileHandler.writeResults(testPoints, testPolygon, results, testFileLocation);
		
		try {
			Scanner testScanner = new Scanner(new File(testFileLocation));
			testScanner.nextLine();
			assertTrue(testScanner.nextLine().equals(testPolygon.toString()));
			testScanner.nextLine();
			assertTrue(testScanner.nextLine().equals(testPoints.get(0).toString() + " : " + results.get(0).toString()));
			assertTrue(testScanner.nextLine().equals(testPoints.get(1).toString() + " : " + results.get(1).toString()));
		} 
		catch (FileNotFoundException e) {
		System.out.println("Error: Could not find test file for write test.");
		}
	}
	

}
