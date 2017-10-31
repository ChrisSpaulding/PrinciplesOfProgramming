


import java.util.ArrayList;
/**
 *
 * @author chris_000
 */
public class ErrorFinder {
    ArrayList<LineOfText> textToCheck;
    ArrayList<String> operators;
    
    public ErrorFinder(ArrayList<LineOfText> textToCheck){
        this.textToCheck=textToCheck;
    }
    
    public void setText(ArrayList<LineOfText> newText){
        this.textToCheck=newText;
    }
    
    public ArrayList<LineOfText> findErrors(){
       BraceAlign braceError = new BraceAlign(this.textToCheck);
       this.textToCheck=braceError.checkBraces();
       
       MethodSpacing spaceCheck = new MethodSpacing(this.textToCheck);
       this.textToCheck= spaceCheck.checkForNeededBlankLines();
       
       OptionalCurlyBraces oCB = new OptionalCurlyBraces(this.textToCheck);
       this.textToCheck = oCB.checkTextForBraces();
       
       
       this.textToCheck = OperatorError.opperatorChecker(textToCheck);
       
        Casing caser = new Casing(this.textToCheck);
        this.textToCheck= caser.ensureClassCapitalization();
        
        LengthChecker lengthChecker = new LengthChecker(this.textToCheck);
        this.textToCheck= lengthChecker.checkLength();
        
        AlphabeticalOrder alphaCheck = new AlphabeticalOrder(this.textToCheck);
        this.textToCheck= alphaCheck.checkAlphaOrderMethods();
        
        
      // this.readText();
       return this.textToCheck;
    }
    
    public void readText(){
       for(int i=0; i<this.textToCheck.size(); i++){
          if(this.textToCheck.get(i).getError()){
          System.out.println(this.textToCheck.get(i).getText()
          +  " error:: "+
                  this.textToCheck.get(i).getErrorMessage()+" Line "+(i+1));
            
           }
       }
    }
   
}
