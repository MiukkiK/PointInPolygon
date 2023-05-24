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
	 * Static method for reading the contents of a File into a String.
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
	 * Static method for writing results of a test into a File, or if no valid File given, print to console.
	 * File format "src\\folder\\targetfile.txt"
	 * File must exist beforehand. Contents of the file will be overwritten.
	 * 
	 * @param resultString String to be written.
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
}
