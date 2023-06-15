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
	 * @return File contents as a String.
	 * 
	 */	
	public static String fileAsString (String source) {
		Path filePath = Paths.get(source);
		try {
			return Files.readString(filePath);
		} catch (IOException e) {
			System.out.println("Error reading file: " + source);
			return "error";
		}
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
	 * Writes a String to a File.
	 * File format "src\\folder\\targetfile.txt"
	 * File must exist beforehand. Contents of the file will be overwritten.
	 * 
	 * @param string String to be written.
	 * @param target Target File location.
	 */
	public static void writeToFile(String target, String string) {
		try {
			FileWriter fileWriter = new FileWriter(target);
			fileWriter.write(string);
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + target);				
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
}
