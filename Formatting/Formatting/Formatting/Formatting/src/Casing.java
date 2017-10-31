/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.Character.isUpperCase;
import java.util.ArrayList;

/**
 *
 * @author Spaulding
 */
public class Casing {

    private ArrayList<LineOfText> textToCheck;

    public Casing(ArrayList<LineOfText> textToCheck) {
        this.textToCheck = textToCheck;
    }

    
    public ArrayList<LineOfText> ensureClassCapitalization() {
        int classDeclaration = findClassLine();
        if(! isClassNameProper(classDeclaration)){
            this.textToCheck.get(classDeclaration).setError("Class name should have the first letter Capitalized");
        }
        for(int i=0; i<textToCheck.size();i++){
            if(this.checkLineForConstant(i)){
                if(! this.isConsantCapital(i)){
                    this.textToCheck.get(i).setError("Constants must be all Upper Case");
                }
            }
            if(this.checkLineForMethods(i)){
                if(! this.isMethodNameLowerCase(i)){
                    this.textToCheck.get(i).setError("Methods must Start with a lower case letter");
                }
            }
        }

        return this.textToCheck;
    }
    
    
    
    public boolean checkLineForConstant(int line){
        return this.textToCheck.get(line).getText().contains(" final ");
    }
    
    public boolean checkLineForMethods(int line){
        String text=this.textToCheck.get(line).getText();
        return ((text.contains(" private ")|| text.contains(" public "))&& 
                    text.contains("("));
    }
    
    public int findClassLine() {
        for (int i = 0; i < this.textToCheck.size(); i++) {
            if (this.textToCheck.get(i).getText().contains(" class ")) {
                return i;
            }
        }
        return -1;
    }
    

    public boolean isConsantCapital(int lineNumber) {
        String line = this.textToCheck.get(lineNumber).getText();
        int charPointer = line.indexOf('=');

        if (notJustWhiteSpaceBeforePos(charPointer, line)) {

            charPointer--;
            if (line.charAt(charPointer) == ' ') {
                while (line.charAt(charPointer) == ' ') {
                    charPointer--;
                }

            }
            while (line.charAt(charPointer) != ' ') {
                charPointer--;
            }
            charPointer++;

            return stringAtPosIsUpperCase(charPointer, line);
        } else {

            int variableLineNumber = lineNumber - 1;
            String variableLineText = this.textToCheck.get(variableLineNumber).getText();
            while (notJustWhiteSpaceBeforePos(variableLineText.length() - 1, variableLineText)) {
                variableLineNumber--;
            }
            variableLineText = this.textToCheck.get(variableLineNumber).getText();
            variableLineText = variableLineText.trim();

            charPointer = variableLineText.length() - 1;

            while (line.charAt(charPointer) != ' ') {
                charPointer--;
            }
            charPointer++;
            return stringAtPosIsUpperCase(charPointer, variableLineText);
        }

    }

    public boolean stringAtPosIsUpperCase(int charPointer, String line) {

        String variableName = "";
        while ((line.charAt(charPointer) != ' ' && line.charAt(charPointer) != '=') && charPointer < line.length() - 1) {
            variableName = variableName + line.charAt(charPointer);
            charPointer++;
        }
        return (variableName.equals(variableName.toUpperCase()));
    }

    public boolean notJustWhiteSpaceBeforePos(int pos, String line) {
        if (pos != 0) {
            pos--;
        }
        while (pos >= 0) {
            if (line.charAt(pos) == ' ') {
                pos--;
            } else {
                return true;
            }

        }
        return false;
    }

    public boolean isClassNameProper(int lineToCheck) {

        String line = this.textToCheck.get(lineToCheck).getText();
        int pos = line.indexOf("class");
        pos = pos + 5;
        while (pos < line.length()) {
            if (line.charAt(pos) == ' ') {
                pos++;
            } else {
                return isUpperCase(line.charAt(pos));

            }
        }
        return false;
    }

    public boolean isMethodNameLowerCase(int lineNumber) {
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

        return java.lang.Character.isLowerCase(text.charAt(openParen));

    }

}
