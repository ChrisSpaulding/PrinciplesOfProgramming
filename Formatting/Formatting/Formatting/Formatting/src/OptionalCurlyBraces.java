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
public class OptionalCurlyBraces {
     private ArrayList<LineOfText> textToCheck;
     
     public OptionalCurlyBraces(ArrayList<LineOfText> textToCheck){
         this.textToCheck=textToCheck;
         
     }
     
     
    
     
     
     public ArrayList<LineOfText> checkTextForBraces(){
         for (int i=0; i<this.textToCheck.size();i++){
             
             if(checkForLoop(i)){
                
                 if(!checkForBrace(i)){
                     this.textToCheck.get(i).setError("There are missing brackets");
                 }
             }
         }
         return this.textToCheck;
     }
     
     
     public boolean checkForBrace(int lineNumber){
         if (lineNumber< this.textToCheck.size()-1){
             if(this.textToCheck.get(lineNumber).getText().contains("{")){
                 return true;
             }
             else {
                 return this.textToCheck.get(lineNumber+1).getText().contains("{");
             }
         }
         return false;
     }
     
     
     
     
     public boolean checkForLoop(int lineNumber){
         String text= this.textToCheck.get(lineNumber).getText();
    
     
         if (text.contains(" for") ){
            
             int pos= text.indexOf("for");
             if(pos+4<text.length()){
                 return (text.charAt(pos+3)==' '||text.charAt(pos+3)==('('));
             }
             return true;
         }
         if (text.contains(" while") ){
        
             int pos= text.indexOf("while");
             if(pos+5<text.length()){
                 return (text.charAt(pos+5)==' '||text.charAt(pos+5)==('('));
             }
             return true;
         }
         if (text.contains(" do") ){
           
            int pos= text.indexOf("do");
             if(pos+2<text.length()){
                 return (text.charAt(pos+2)==' '||text.charAt(pos+2)==('('));
             }
             return true;
         }
         if(text.contains(" if")){
             int pos = text.indexOf("do");
             if(pos+2<text.length()){
                 return (text.charAt(pos+2)==' '||text.charAt(pos+2)==('('));
             }
             return true;
         }
         
         if(text.contains(" else")){
             int pos = text.indexOf("else");
             if(pos+4<text.length()){
                 return (text.charAt(pos+4)==' '||text.charAt(pos+4)==('('));
             }
             return true;
         }
         
       
         return false;
         
     }
     
    
     
     
}
