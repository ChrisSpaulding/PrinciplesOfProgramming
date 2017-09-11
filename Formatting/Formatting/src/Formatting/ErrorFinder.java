
package Formatting;

import java.util.ArrayList;
/**
 *
 * @author chris_000
 */
public class ErrorFinder {
    ArrayList<LineOfText> textToCheck;
    ArrayList<String> operators;
    
    ErrorFinder(ArrayList<LineOfText> textToCheck){
        this.textToCheck=textToCheck;
    }
    
    public ArrayList<LineOfText> findErrors(){
        BraceAlingment braceError = new BraceAlingment(this.textToCheck);
        this.textToCheck=braceError.checkBraces();
        return this.textToCheck;
    }
    
    public void readText(){
       for(int i=0; i<this.textToCheck.size(); i++){
          System.out.println(this.textToCheck.get(i).getText()
          +  " error:: "+
                  this.textToCheck.get(i).getError());
       }
    }
   
}
