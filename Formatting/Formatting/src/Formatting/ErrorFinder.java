
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
        this.textToCheck = OperatorError.opperatorChecker(this.textToCheck);
        LengthChecker lengthCheck= new LengthChecker();
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
