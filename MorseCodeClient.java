import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeClient {

	public static void main(String[] args) {
    	try {
    		Scanner scanner = new Scanner(new File("C:\\Users\\mycol\\Documents\\morseCode.txt"));
    		while(scanner.hasNext()) {
    			String line = scanner.nextLine();
    			line.replaceAll("\\s", ""); //removes white space
    			System.out.println(line);
    			String symbol = line.substring(0, 1); //adds character
    			System.out.println(symbol);
    			//add(symbol, line.substring(1)); //adds morse code
    		}
      		
    	} catch (FileNotFoundException exception) {
    		System.out.println("File not found!");
    	}

	}

}
