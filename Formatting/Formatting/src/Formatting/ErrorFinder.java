
package Formatting;

import java.util.ArrayList;
import java.lang.CharSequence;
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
        
        LengthChecker lengthCheck= new LengthChecker(OperatorError.opperatorChecker(this.textToCheck));
        this.textToCheck=lengthCheck.checkLength(40);
        
        return this.textToCheck;
    }
    
    public void readText(){
       for(int i=0; i<this.textToCheck.size(); i++){
          System.out.println(this.textToCheck.get(i).getText()+" ::line number::"
          + this.textToCheck.get(i).getLineNumber()+ " error:: "+
                  this.textToCheck.get(i).getError());
       }
    }
   
}
