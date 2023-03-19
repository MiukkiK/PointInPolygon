import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Class to handle file actions.
 * @author Mia Kallio
 *
 */
public class FileHandler {
	/**
	 * Reads points from a given file location in String format and returns the results in a linked list.
	 * @param source Location of the File in String format.
	 * @return a LinkedList of the points in the given file.
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
