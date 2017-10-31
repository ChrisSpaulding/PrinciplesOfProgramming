
import java.util.Scanner;

/* used code from 
https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html 
for reading in a file
*/



/**
 *
 * @author chris_000
 */
public class Formatting {
  
    /**
     * @param args could be the file location for the file to run?
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.println("Please enter the file path of the file you wish to scan");
       String fileNameTemp = in.nextLine();
       
       
       ErrorFinder errorFinder= new ErrorFinder(FileConverter.readInLines(fileNameTemp));
       errorFinder.findErrors();
       errorFinder.readText();
     
       fileNameTemp= "C:\\Users\\chris_000\\Documents\\School\\PrinciplesofProgramming\\Formatting2\\Formatting(3)\\Formatting\\Formatting\\TestCases\\David_multiple.txt";
       errorFinder.setText(FileConverter.readInLines(fileNameTemp));
       errorFinder.findErrors();
       errorFinder.readText();
     
       
       errorFinder.setText(FileConverter.readInLines(fileNameTemp));
       errorFinder.findErrors();
       errorFinder.readText();
       
       
       errorFinder.setText(FileConverter.readInLines(fileNameTemp));
       errorFinder.findErrors();
       errorFinder.readText();
       
    }
 
    
    
}
