/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Spaulding
 */
public class MethodSpacing {
    private ArrayList<LineOfText> textToCheck;
    private ArrayList <OpeningBrace> OpenBraces;   
         
    MethodSpacing(ArrayList<LineOfText> textToCheck){
          this.textToCheck=textToCheck;
          this.OpenBraces= new ArrayList <OpeningBrace>();
      }
      
    public ArrayList<LineOfText> checkForNeededBlankLines(){
        checkSpaceAfterClassHeader();
        checkSpaceAfterMethods();
        checkSpaceAfterDeclarations();
        return this.textToCheck;
        
}
    
    public ArrayList<LineOfText> checkSpaceAfterDeclarations(){
        int firstMethodLine = findSecondOpeningBracket();
        if(firstMethodLine==0){
            this.textToCheck.get(firstMethodLine).setError("This should not have two oppening Brackets");
        }
        this.checkForOneBlankLine(firstMethodLine-3,"Space After Declarations, and "
                + "before methods");
        return this.textToCheck;
    }
    
    private int findSecondOpeningBracket(){
        int bracketLine=0;
        this.OpenBraces.clear();
        for (int i = 0; i < this.textToCheck.size(); i++) {
            String textLine = this.textToCheck.get(i).getText();
            if (textLine.contains("{")) {
                this.OpenBraces.add(new OpeningBrace(0, i));
            }
        }
        if(this.OpenBraces.size()>=1){
            bracketLine=this.OpenBraces.get(1).getLineNumber();
        }
        this.OpenBraces.clear();
        return bracketLine;
    }
    
    
    public ArrayList<LineOfText> checkSpaceAfterClassHeader(){
        for( int i=0; i<this.textToCheck.size();i++){
            if(this.textToCheck.get(i).getText().contains("class")){
                if(this.checkForOneBlankLine(i+1, "Blank AFter Class Header")){
                    return this.textToCheck;
                }
            }
        }
        return this.textToCheck;
    }
    
    
    public ArrayList<LineOfText> checkSpaceAfterMethods(){
        if(this.textToCheck.isEmpty()){
            return this.textToCheck;
        }
       
        for (int i = 0; i < this.textToCheck.size(); i++) {
            String textLine = this.textToCheck.get(i).getText();
            if (textLine.contains("{")) {
                this.OpenBraces.add(new OpeningBrace(0, i));
            }
            if (textLine.contains("}") ) {
                if(isBlankLineNeededAfterCloseBracket()){
                    checkForOneBlankLine(i,"Space after Methods");               
                }
            } 
        }
        return this.textToCheck;
    }
       
       
       
    /**
     * Checks to see if a BlankSpace is needed after a bracket
     * @return  
     */
    private boolean isBlankLineNeededAfterCloseBracket(){
        if(this.OpenBraces.size()>0);
        {
            this.OpenBraces.remove(OpenBraces.size()-1);
        }
        return (this.OpenBraces.size()<=1); 
        
    }
    
    private boolean checkForOneBlankLine(int lineNumber, String error){
        if(this.textToCheck.size()== lineNumber+1){
            return false;
        }
        if(this.textToCheck.get(lineNumber+1).getText().equalsIgnoreCase("")){ 
            if( this.textToCheck.get(lineNumber+2).getText().equalsIgnoreCase("")){
                this.textToCheck.get(lineNumber+2).setError("Should not be blank");
                return true;
            }
            else{
                return false;
            }
        }
        else{
            this.textToCheck.get(lineNumber+1).setError("This should be blank "+ error);
            return true;
        }
    }
    
}
