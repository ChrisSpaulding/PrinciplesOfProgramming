package Formatting;

/**
 * Class that will hold one line of text and it's position in the document 
 * @author chris_000
 */

public class LineOfText {
    private final String text; 
    private final int lineNumber;
    public boolean error;

    LineOfText(){
        text="";
        lineNumber=-1;
        error=false;
    }
    LineOfText(String text, int lineNumber){
        this.text=text;
        this.lineNumber= lineNumber;
        error=false;
       }
    
    public String getText(){
        return text;
    }
    
    public int getLineNumber(){
        return lineNumber;
    }
    
    public void setFalse(){
        this.error=false;
    }
    public void setTrue(){
        this.error=true;
    }
    

}
