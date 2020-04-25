import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Enter { 

    public static void main(String[] args) {

    	//Initialize an object for FileBuilder
        FileBuilderFactory fb = new FileBuilder();

        //Get instance of CommandExecuter class
        CommandExecuter runner = CommandExecuter.getInstance(fb);

        //Take script2.txt file as input and read each line as String. The string is passed to the
        //FileBuilder's runScript() function.
        try {
			File command = new File("script2.txt");
			Scanner fileReader = new Scanner(command);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				runner.runCommandExecuter(data);
			}
			fileReader.close();
        } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
        }
    }  
   
} 