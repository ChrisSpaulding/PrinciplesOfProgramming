package Formatting;

/**
 * Class that will hold one line of text and it's position in the document 
 * @author chris_000
 */

public class LineOfText {
    private final String text; 
    private final int lineNumber;
    private boolean error;

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
    
    public boolean getError(){
        return this.error;
    }
    
    
    public int getLineNumber(){
        return this.lineNumber;
    }
    public String getText(){
        return this.text;
    }
    
    public void setFalse(){
        this.error=false;
    }
    public void setErrorFlagTrue(){
        this.error=true;
    }
    

}
