
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Spaulding
 */
public class AlphabeticalOrder {

    private ArrayList<LineOfText> textToCheck;
    private ArrayList<MethodNames> methodNames;
    
    public AlphabeticalOrder(ArrayList<LineOfText> textToCheck) {
        this.textToCheck = textToCheck;
        this.methodNames= new ArrayList<>();

    }
    
    
    
    
    public ArrayList<LineOfText> checkAlphaOrderMethods(){
        for (int i=0; i<this.textToCheck.size();i++){
            if (this.checkLineForMethods(i)){
                this.methodNames.add(new MethodNames(getMethodName(i), i));
            }
        }
      
        checkOrderOfMethodNames();
        return this.textToCheck;
    }
    
    /**
     * marks a method as not in order if the method below it should be before it.
     */
    private void checkOrderOfMethodNames(){
        for (int i=0; i<this.methodNames.size()-1;i++){
            String name1=this.methodNames.get(i).getName();
            String name2=this.methodNames.get(i+1).getName();
            if(name1.compareTo(name2)<0){
                
            }
            else {
                this.textToCheck.get(this.methodNames.get(i+1).getLineNumber()).setError(
                "This function is alphabetically before the Function above");
            }
            
        }        
    }
    

    public String getMethodName(int lineNumber) {
        String text = this.textToCheck.get(lineNumber).getText();
        int openParen = text.indexOf("(");
        openParen--;
        if (text.charAt(openParen) == ' ') {
            while (text.charAt(openParen) == ' ') {
                openParen--;
            }
            openParen--;
        }
        while (text.charAt(openParen) != ' ') {
            openParen--;
        }
        openParen++;
        String methodName="";
        while((openParen<text.length()-1 )&& (text.charAt(openParen) != ' ')){
            methodName=methodName+text.charAt(openParen);
            openParen++;
        }
        
        return methodName;
    }

    public boolean checkLineForMethods(int line) {
        String text = this.textToCheck.get(line).getText();
        return ((text.contains(" private ") || text.contains(" public "))
                && text.contains("("));
    }
}
