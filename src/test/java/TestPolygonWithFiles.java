/**
 * Test class for fringe cases of the Polygon.whereIs() method.
 * This variation tests using File reads and writes.
 * 
 * @author Mia Kallio
 */
public class TestPolygonWithFiles extends AbstractPolygonTest {

	Polygon getPolygon(String source) {
		String fileSource = "not initialized";
		switch (source) {
		case "triangle": 
			fileSource = "src\\test\\resources\\triangle.txt";
			break;
		case "doublejoint": 
			fileSource = "src\\test\\resources\\doublejointedtriangle.txt";
			break;
		case "mshape": 
			fileSource = "src\\test\\resources\\mshape.txt";
			break;
		}
		return new Polygon(Point.getPointsFromString(FileHandler.fileAsString(fileSource)));
	}
	
	Point[] getPoints(String source) {
		String fileSource = "not initialized";
		switch (source) {
		case "triangle": 
			fileSource = "src\\test\\resources\\triangle_testpoints.txt";
			break;
		case "doublejoint": 
			fileSource = "src\\test\\resources\\doublejointedtriangle_testpoints.txt";
			break;
		case "mshape": 
			fileSource = "src\\test\\resources\\mshape_testpoints.txt";
			break;
		}
		return Point.getPointsFromString(FileHandler.fileAsString(fileSource));
	}

	String[] getResults(String source) {
		String fileSource = "not initialized";
		switch (source) {
		case "triangle": 
			fileSource = "src\\test\\resources\\triangle_assertresults.txt";
			break;
		case "doublejoint": 
			fileSource = "src\\test\\resources\\doublejointedtriangle_assertresults.txt";
			break;
		case "mshape": 
			fileSource = "src\\test\\resources\\mshape_assertresults.txt";
			break;
		}
		String[] results = FileHandler.fileAsString(fileSource).split(",");
		return results;
	}

}
