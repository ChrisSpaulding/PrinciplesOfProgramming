/* used code from 
https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html 
for reading in a file
*/
package Formatting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author chris_000
 */
public class Formatting {
  
    /**
     * @param args could be the file location for the file to run?
     */
    public static void main(String[] args) {
        // The name of the file to open.
        String fileName = "C:\\Users\\chris_000\\Documents\\School\\PrinciplesofProgramming\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
       ArrayList<LineOfText> textHolder = new ArrayList();
       
       
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int lineCount=0;
            while((line = bufferedReader.readLine()) != null) {
                lineCount++;
                LineOfText temp = new LineOfText(line,lineCount);
                textHolder.add(temp);
                
            }
            

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    
    
    
}
