package Formatting;

import java.util.ArrayList;

/**
 *
 * @author chris_000
 */
public class BraceAlingment {
    int numberOfBrackets;
    ArrayList<Integer> lineOfOppeningBracket;
    ArrayList<LineOfText> textToCheck;
    ArrayList<Integer> bracketPositon;
    BraceAlingment(ArrayList<LineOfText> text){
        this.textToCheck=text;
        this.bracketPositon = new ArrayList<Integer>();
        this.lineOfOppeningBracket = new ArrayList<Integer>();
    }
    
    public ArrayList<LineOfText> checkBraces(){
        for(int i=0; i<this.textToCheck.size();i++){
            String textLine = this.textToCheck.get(i).getText();
            if(textLine.contains("{")){
                this.numberOfBrackets++;
                this.bracketPositon.add((Integer)this.positionOfOppenBraces(textLine));
                this.lineOfOppeningBracket.add(i);
            }
            if(textLine.contains("}")){
                int closePosition= this.positionOfCloseBraces(textLine);
                if(closePosition==this.bracketPositon.get(numberOfBrackets-1)){
                    this.numberOfBrackets--;
                }
                else{
                    this.textToCheck.get(this.lineOfOppeningBracket.get(
                            this.numberOfBrackets-1)).setTrue();
                    this.numberOfBrackets--;
                }
            }
        }
        
        
        
        return this.textToCheck;
    }
    
    private int positionOfOppenBraces(String line){
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='{'){
                return i;
            }
        }
    return -1;    
    }
    
    private int positionOfCloseBraces(String line){
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='}'){
                return i;
            }
        }
    return -1;    
    }    
}
