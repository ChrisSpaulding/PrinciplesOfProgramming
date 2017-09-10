package Formatting;

import java.util.ArrayList;

/**
 *
 * @author chris_000
 */
public class OperatorError {



    public static ArrayList<LineOfText> opperatorChecker(ArrayList<LineOfText> textToCheck) {
        for (int i = 0; i < textToCheck.size(); i++) {
            String line = textToCheck.get(i).getText();
            if (findSurroundedOpperators(line)) {
                textToCheck.get(i).setTrue();
            }
        }
        return textToCheck;
    }

    /**
     *
     * @param line to evaluate for surrounded operators
     * @return true if there are surrounded operators
     */
    private static boolean findSurroundedOpperators(String line) {
        for (int i = 2; i < line.length(); i++) {
            char firstChar = line.charAt(i - 2);
            char secondChar = line.charAt(i - 1);
            char thirdChar = line.charAt(i);
            if (firstChar != secondChar && secondChar != thirdChar) {
                if ((firstChar == '/' && secondChar == '*') || (secondChar == '/' & thirdChar == '*')) {
                    return false;
                }
                if ((firstChar == '*' && secondChar == '/') || (secondChar == '*' & thirdChar == '/')) {
                    return false;
                }
                if (secondChar == '+' && (thirdChar != ' ' || firstChar != ' ')) {
                    return true;
                }
                if (secondChar == '-' && (firstChar != ' ' || thirdChar != ' ')) {
                    return true;
                }
                if (secondChar == '*' && (firstChar != ' ' || thirdChar != ' ')) {
                    return true;
                }
                if (secondChar == '/' && (firstChar != ' ' || thirdChar != ' ')) {
                    return true;
                }
                if (secondChar == '%' && (firstChar != ' ' && thirdChar != ' ')) {
                    return true;
                }
            }
        }
        return false;
    }

}
