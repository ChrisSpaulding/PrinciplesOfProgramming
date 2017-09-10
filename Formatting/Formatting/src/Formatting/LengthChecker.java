package Formatting;

import java.util.ArrayList;
/**
 *
 * @author chris_000
 */
public class LengthChecker {
    private    ArrayList<LineOfText> textToCheck;
    private boolean commentFlag;
    private final int MAXLENGTH=80;
    
    LengthChecker(ArrayList<LineOfText> textToCheck){
        this.textToCheck=textToCheck;
        commentFlag=false;
    }
    
    public ArrayList<LineOfText> checkLength(){
        return this.checkLength(MAXLENGTH);
    }
    
    public ArrayList<LineOfText> checkLength(int maxSize){
       for(int i=0;i<this.textToCheck.size();i++){
           if(this.textToCheck.get(i).getText().length()>maxSize &&
                   !this.setCommentFlag(i)){
               this.textToCheck.get(i).setTrue();
           }
       }   
       return this.textToCheck;
   }
    
   private boolean setCommentFlag(int line){
       if(this.textToCheck.get(line).getText().contains("/*")){
           this.commentFlag=true;
           
       }
       if(this.textToCheck.get(line).getText().contains("*/")){
    
            this.commentFlag=false;
       }
    return this.commentFlag;   
   }
        
    
}
