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
	public static String fileAsString (String input) {
		Path filePath = Paths.get(input);
		if (Files.exists(filePath))
			try {
				return Files.readString(filePath);
			} catch (IOException e) {
				System.out.println("Error while parsing file: " + input);
				return "";
			}
		else return input;
	}
/**
 * Static method for writing results of a test into a File, or if no valid File given, print to console.
 * File format "src\\folder\\targetfile.txt"
 * File must exist beforehand. Contents of the file will be overwritten.
 * 
 * @param resultString String to be written.
 * @param target Target File location.
 */
	public static void writeResults(String resultString, String target) {
		if ((target != "") && Files.exists(Paths.get(target)))
			try {
				FileWriter fileWriter = new FileWriter(target);
				fileWriter.write(resultString);
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while writing to file: " + target);				
			}
		else {
			System.out.print(resultString);
		}		
	}
}
