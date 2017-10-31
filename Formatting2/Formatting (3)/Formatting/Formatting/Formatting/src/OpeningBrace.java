


/**
 *
 * @author chris_000
 */
public class OpeningBrace {

    private final int position; 
    private final int lineNumber;

    
    OpeningBrace( int position, int lineNumber){
        this.position=position;
        this.lineNumber=lineNumber;

    }
    
    public int getPosition (){
        return this.position;
    }
    
    public int getLineNumber(){
        return this.lineNumber;
    }    
}
