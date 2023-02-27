import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class to handle file actions.
 * @author Mia Kallio
 *
 */
public class FileHandler {
	private static String RESULTS_FOR = "Tulokset polygonille:";
	/**
	 * Reads points from a given file location in String format and returns the results in a linked list.
	 * @param source Location of the File in String format.
	 * @return a LinkedList of the points in the given file.
	 */
	public LinkedList<Point> readPoints(String source) {
		/**
		 * A LinkedList of Point objects in the file.
		 */
		LinkedList<Point> points = new LinkedList<Point>();

		try (Scanner scanner = new Scanner(new File(source)).useDelimiter("([()]|\\s)+")) {
			while (scanner.hasNext()) {
				points.add(new Point(scanner.next()));
				}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file " + source);
		}
		return points;
	}
	public void writeResults(LinkedList<Point> points, Polygon polygon, LinkedList<String> results, String target) {
		File saveFile = new File(target);
		try {
		if (!(saveFile.isFile())) saveFile.createNewFile();
		FileWriter fileWriter = new FileWriter(saveFile);
		fileWriter.write(RESULTS_FOR + "\n" + polygon.toString() + "\n\n");
		int i=0;
		while (i < points.size()) {
 			fileWriter.write(points.get(i).toString() + " : " + results.get(i) + "\n");
 			i++;
		}
		fileWriter.write("\n");
		fileWriter.close();
		} catch (IOException e) {
			System.out.println("IO Exception while writing results to file.");
		}
	}
}
