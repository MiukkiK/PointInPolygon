import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Class for reading and writing Strings to Files.
 * 
 * @author Mia Kallio
 */
public class FileHandler {
	/**
	 * Read the contents of a File into a String.
	 * File format "src\\folder\\inputfile.txt"
	 * 
	 * @param source Location of the File in String format.
	 * @return File contents as a String if a valid file, otherwise the input string.
	 * 
	 */	
	public static String fileAsString (String source) {
		Path filePath = Paths.get(source);
		if (Files.exists(filePath))
			try {
				return Files.readString(filePath);
			} catch (IOException e) {
				System.out.println("Error while parsing file: " + source);
				return "";
			}
		else return source;
	}
	/**
	 * Reads a File for a list of results in Polygon.Position enum format.
	 * @param source Location of the File in String format.
	 * @return an Array of Polygon.Position.
	 */
	public static Polygon.Position[] readResultsFromFile(String source) {
		String[] fileStrings = fileAsString(source).split(",");
		Polygon.Position[] fileResults = new Polygon.Position[fileStrings.length];
		for (int i=0; i<fileStrings.length; i++) {
			switch(fileStrings[i]) {
				case "inside":
					fileResults[i] = Polygon.Position.INSIDE;
					break;
				case "outside":
					fileResults[i] = Polygon.Position.OUTSIDE;
					break;
				case "on the border":
					fileResults[i] = Polygon.Position.ON_BORDER;
					break;
					
			}
		}
 		return fileResults;
	}
	/**
	 * Writes a String to a File, or if no valid File given, print to console.
	 * File format "src\\folder\\targetfile.txt"
	 * File must exist beforehand. Contents of the file will be overwritten.
	 * 
	 * @param string String to be written.
	 * @param target Target File location.
	 */
	public static void writeToFile(String target, String string) {
		if ((target != "") && Files.exists(Paths.get(target)))
			try {
				FileWriter fileWriter = new FileWriter(target);
				fileWriter.write(string);
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while writing to file: " + target);				
			}
		else {
			System.out.print(string);
		}		
	}
	/**
	 * Writes the String representations of the Objects in given Array to target location.
	 * @param target Target File location in String format.
	 * @param array given Array of Objects.
	 * @param splitter String used to split Objects in the written File.
	 */
	public static void writeArrayToFile(String target, Object[] array, String splitter) {
		String compiledString = "";
		for (Object arrayPart : array) {
			if (compiledString != "") compiledString = compiledString + splitter;
			compiledString = compiledString + arrayPart.toString();
		}
		writeToFile(target, compiledString);
	}
	/**
	 * Form a result String in printable format from Polygon, test Point array and Polygon.Position enum array.
	 * @param polygon tested Polygon.
	 * @param points Array of Points tested.
	 * @param results Array of Polygon.Position enum results.
	 * @return Results in a String for printing to file or console.
	 */
	public static String formulateResults (Polygon polygon, Point[] points, Polygon.Position[] results) {
		String resultString = "Results for polygon:" + System.lineSeparator() + polygon.toString() + System.lineSeparator() + System.lineSeparator();
		for (int i=0; i < points.length; i++) {		
			resultString = resultString + points[i].toString() + ": " + results[i] + System.lineSeparator();
		}
		return resultString;
	}
}
