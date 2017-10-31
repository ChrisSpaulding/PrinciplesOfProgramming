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
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
       ErrorFinder errorFinder= new ErrorFinder(FileConverter.readInLines(fileNameTemp));
       errorFinder.findErrors();
       errorFinder.readText();
      
    }
 
    
    
}
