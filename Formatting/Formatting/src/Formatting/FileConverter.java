
package Formatting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author chris_000
 */
public class FileConverter {

    /**
     *
     * @param fileName
     * @return ArrayList<LineOfText> of the file, one object per line
     */
    public static ArrayList<LineOfText> readInLines(String fileName){
       ArrayList<LineOfText> textHolder = new ArrayList();
       String line = null;
        try {
            java.io.FileReader fileReader = new java.io.FileReader(fileName);
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
