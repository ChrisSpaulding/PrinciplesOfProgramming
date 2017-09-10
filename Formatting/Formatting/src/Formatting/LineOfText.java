package Formatting;

/**
 * Class that will hold one line of text and it's position in the document 
 * @author chris_000
 */
class LineOfText {
    private final String text; 
    private final int lineNumber;
    
    LineOfText(String text, int lineNumber){
        this.text=text;
        this.lineNumber= lineNumber;
       }
    
    public String getText(){
        return text;
    }
    
    public int getLineNumber(){
        return lineNumber;
    }

}
