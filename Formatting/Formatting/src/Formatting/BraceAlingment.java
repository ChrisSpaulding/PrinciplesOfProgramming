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
    
    /**
     * 
     * @return an ArrayList of type LineOfText with the lines error set, if only the
     * opening bracket is set then the brackets are not lined up with the line 
     * before.
     * 
     */
    
    public ArrayList<LineOfText> checkBraces(){
        for(int i=0; i<this.textToCheck.size();i++){
            String textLine = this.textToCheck.get(i).getText();
            if(textLine.contains("{")){
                if(i==0){
                    this.textToCheck.get(i).setTrue();
                }
                this.numberOfBrackets++;
                this.lineOfOppeningBracket.add(i);
                this.bracketPositon.add((Integer)this.positionOfOppenBraces(textLine));
                if(i!=0){
                    int pos = this.countOppeningSpaces(textToCheck.get(i-1).getText());
                    if(pos != this.bracketPositon.get(numberOfBrackets-1)){
                        this.textToCheck.get(i).setTrue();
                    }
                }
                
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
                    this.textToCheck.get(i).setTrue();
                }
            }
        }
        
        
        
        return this.textToCheck;
    }
    
    private int countOppeningSpaces(String line){
        int count=0;
        int pos=0;
        while(pos<line.length()&& (line.charAt(pos)==' '))
        {
            count++;
            pos++;
        }
        return count;
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
