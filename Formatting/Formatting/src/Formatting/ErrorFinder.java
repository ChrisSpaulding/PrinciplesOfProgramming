
package Formatting;

import java.util.ArrayList;

/**
 *
 * @author chris_000
 */
public class ErrorFinder {
    ArrayList<LineOfText> textToCheck;
    
    
    ErrorFinder(ArrayList<LineOfText> textToCheck){
        this.textToCheck=textToCheck;
    }
    
   public void readText(){
      for(int i=0; i<this.textToCheck.size(); i++){
          System.out.println(this.textToCheck.get(i).getText()+" ::line number::"
          + this.textToCheck.get(i).getLineNumber());
      }
   }

}
