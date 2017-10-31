/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Spaulding
 */
public class MethodNames {
    private final String name;
    private final int lineNumber;
    
    MethodNames(String name, int lineNumber){
        this.name=name;
        this.lineNumber=lineNumber;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLineNumber(){
        return this.lineNumber;
    }
    
    
}
