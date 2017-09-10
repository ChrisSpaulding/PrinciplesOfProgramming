
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
    
    
    public void opperatorChecker(){
        for(int i=0;i<textToCheck.size();i++){
            String line=textToCheck.get(i).getText();
            if(this.findSurroundedOpperators(line)){
                this.textToCheck.get(i).setTrue();
            }    
        }
    }
    

    public boolean findSurroundedOpperators(String line){
    for (int i=2;i<line.length();i++){
        char firstChar = line.charAt(i-2);
        char secondChar = line.charAt(i-1);
        char thirdChar = line.charAt(i);
        if(firstChar!=secondChar && secondChar!=thirdChar){
            if( secondChar=='+' && ( thirdChar!=' '|| firstChar!=' ' )){
                return true;
            }
            if(secondChar=='-' && (firstChar!=' ' ||  thirdChar!=' ')){
                return true;
            }
            if(secondChar=='*' && (firstChar!=' ' ||  thirdChar!=' ')){
                return true;
            }
            if(secondChar=='/' && (firstChar!=' ' ||  thirdChar!=' ')){
                return true;
            }
            if(secondChar=='%' && (firstChar!=' ' &&  thirdChar!=' ')){
                return true;
            }
        }
    }
    return false;}
    
    public void readText(){
       for(int i=0; i<this.textToCheck.size(); i++){
          System.out.println(this.textToCheck.get(i).getText()+" ::line number::"
          + this.textToCheck.get(i).getLineNumber()+ " error:: "+
                  this.textToCheck.get(i).error);
       }
    }
   
}
