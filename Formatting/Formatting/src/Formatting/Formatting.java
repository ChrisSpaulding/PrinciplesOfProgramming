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
        Formatting formatter = new Formatting();
        // The name of the file to open.
        String fileNameTemp = "C:\\Users\\chris_000\\Documents\\School\\PrinciplesofProgramming\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        ArrayList<LineOfText> convertedFile = formatter.readInLines(fileNameTemp);
        ArrayList<LineOfText> textHolder = new ArrayList();
       
      
    }
    
    private ArrayList<LineOfText> readInLines(String fileName){
       ArrayList<LineOfText> textHolder = new ArrayList();
       String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int lineCount=0;
            while((line = bufferedReader.readLine()) != null) {
                lineCount++;
                LineOfText temp = new LineOfText(line,lineCount);
                textHolder.add(temp);
            }
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
        }
    return textHolder;
    }
    
}
