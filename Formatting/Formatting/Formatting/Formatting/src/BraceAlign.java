


import java.util.ArrayList;

/**
 *
 * @author Spaulding
 */
public class BraceAlign {

    private ArrayList <OpeningBrace> OpenBraces;
    private ArrayList<LineOfText> textToCheck;
    
    
    BraceAlign(ArrayList<LineOfText> text) {
        this.textToCheck = text;
        this.OpenBraces = new ArrayList<>();
    }
    
    
    /**
     * This will mark the LineOfText with an error if the Open and Closed 
     * Brackets are not in the correct position. 
     * @return 
     */
    public ArrayList<LineOfText> checkBraces(){
        if(this.textToCheck.isEmpty()){
            return this.textToCheck;
        }
        
       for (int i = 0; i < this.textToCheck.size(); i++) {
            String textLine = this.textToCheck.get(i).getText();
            if (textLine.contains("{")) {
                int position= this.positionOfOppenBraces(textLine);
                this.OpenBraces.add(new OpeningBrace(position, i));
                this.CheckOpenBracePosition(i);
            }
            if (textLine.contains("}")) {
                this.closeBracket(i);
            }
        }
       return this.textToCheck;
    }
    
    /**
     * Marks the LineOfText if the opening Bracket does not line up with the line above.
     * @param lineNumber 
     */
    private void CheckOpenBracePosition(int lineNumber){
        if(lineNumber==0){
            this.textToCheck.get(lineNumber).setError("Open Brace Position Error");
        }
        else{
           String previousLine= this.textToCheck.get(lineNumber).getText();
           int position = this.countOppeningSpaces(previousLine);
           if(position != this.mostRecentBrace().getPosition()){
               this.textToCheck.get(lineNumber).setError("Brace does not line up Correctly");
           }
           
        }
    }
    
    /**
     * Checks to see if the position of close brace matches the latest open
     * @param line 
     */
    private void closeBracket(int line){
        String text = this.textToCheck.get(line).getText();
        int position= this.positionOfCloseBraces(text);
        if(mostRecentBrace().getPosition()==position && !this.OpenBraces.isEmpty()){
            this.OpenBraces.remove(this.OpenBraces.size()-1);
        }
        else {
            int lineNumber= mostRecentBrace().getLineNumber();
            this.textToCheck.get(lineNumber).setError("Line up Bracket Error");
            this.textToCheck.get(line).setError("Line up Bracket Error");
        }       
    }
    
    /**
     * Returns the last element in this.OpenBrace. 
     * @return OpeningBrace
     */
    private OpeningBrace mostRecentBrace(){
        return this.OpenBraces.get(this.OpenBraces.size()-1);
    }
    
    /**
    * @param line String
    * @return int of the position of the { character in the String given 
    * -1 for error
    */
    private int positionOfOppenBraces(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '{') {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param line String
     * @return int of the position of the } character in the String given
     * -1 for error
     */
    private int positionOfCloseBraces(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '}') {
                return i;
            }
        }
        return -1;
    }
    
    private int countOppeningSpaces(String line) {
        int pos = 0;
        while (pos < line.length() && (line.charAt(pos) == ' ')) {
            pos++;
        }
        return pos;
    }
}
