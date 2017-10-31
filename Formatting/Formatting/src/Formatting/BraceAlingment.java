package Formatting;
/*
assumptions: that the header is on one line and that the key word is the first line
    Need to check {} {} lines of code that are not nested. 
    get an object to hold the position of the oppening bracket and other info.
*/
import java.util.ArrayList;
/**
 *
 * @author chris_000
 */
public class BraceAlingment {
    
    int numberOfBrackets;
    ArrayList<Integer> lineOfOppeningBracket;
    ArrayList<LineOfText> textToCheck;
    ArrayList<Integer> bracketPositon;

    BraceAlingment(ArrayList<LineOfText> text) {
        this.textToCheck = text;
        this.bracketPositon = new ArrayList<>();
        this.lineOfOppeningBracket = new ArrayList<>();
    }

    /**
     *
     * @return an ArrayList of type LineOfText with the lines error set, if only
     * the opening bracket is set then the brackets are not lined up with the
     * line before.
     *
     */
    public ArrayList<LineOfText> checkBraces() {
        for (int i = 0; i < this.textToCheck.size(); i++) {
            String textLine = this.textToCheck.get(i).getText();
            if (textLine.contains("{")) {
                this.oppenBracket(i, textLine);
            }
            if (textLine.contains("}")) {
                this.closeBracket(i, textLine);
            }
        }
        return this.textToCheck;
    }

    private int countOppeningSpaces(String line) {
        int pos = 0;
        while (pos < line.length() && (line.charAt(pos) == ' ')) {
            pos++;
        }
        return pos;
    }

    /**
     * Checks the position of the closing bracket compared to the opening
     * bracket.
     *
     * @param i
     * @param textLine
     */
    private void closeBracket(int lineNumber, String textLine) {
        int closePosition = this.positionOfCloseBraces(textLine);
        if (closePosition == this.bracketPositon.get(numberOfBrackets - 1)) {
            this.numberOfBrackets--;
            this.bracketPositon.remove(this.bracketPositon.size()-1);
        } else {
            this.textToCheck.get(this.lineOfOppeningBracket.get(
                    this.numberOfBrackets - 1)).setErrorFlagTrue();
            
            this.numberOfBrackets--;
            
            this.textToCheck.get(lineNumber).setErrorFlagTrue();
            this.bracketPositon.remove(this.bracketPositon.size()-1);
        }
    }

    /**
     * Stores the required information to find the matchinig lower bracket
     *
     * @param i
     * @param textLine
     */
    private void oppenBracket(int i, String textLine) {
        if (i == 0) {
            this.textToCheck.get(i).setErrorFlagTrue();
        }
        this.numberOfBrackets++;
        this.lineOfOppeningBracket.add(i);
        this.bracketPositon.add((Integer) this.positionOfOppenBraces(textLine));
        if (i != 0) {
            int pos = this.countOppeningSpaces(textToCheck.get(i - 1).getText());
            if (pos != this.bracketPositon.get(numberOfBrackets - 1)) {
                this.textToCheck.get(i).setErrorFlagTrue();
            }
        }
    }

    /**
     * @param line String
     * @return int of the position of the { character in the String given
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
     */
    private int positionOfCloseBraces(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '}') {
                return i;
            }
        }
        return -1;
    }
}
