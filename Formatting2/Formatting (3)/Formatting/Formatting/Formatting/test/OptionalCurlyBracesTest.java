/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Spaulding
 */
public class OptionalCurlyBracesTest {

    public OptionalCurlyBracesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

 //   @Test
    public void checkForLoopTestTrue() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\OptionalBrackets.txt";
        OptionalCurlyBraces test = new OptionalCurlyBraces(FileConverter.readInLines(fileNameTemp));
        assert (test.checkForLoop(0));
        assert (test.checkForLoop(1));
        assert (test.checkForLoop(2));
        assert (test.checkForLoop(3));
        assert (test.checkForLoop(4));
        assert (test.checkForLoop(5));
        assert (test.checkForLoop(6));
        
        
        
    }

 //   @Test
    public void checkForLoopTestFalse() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\OptionalBrackets.txt";
        OptionalCurlyBraces test = new OptionalCurlyBraces(FileConverter.readInLines(fileNameTemp));
        assert (!test.checkForLoop(7));
        assert (!test.checkForLoop(8));
        assert (!test.checkForLoop(9));
    }

    
    
    
    
    @Test
    public void checkForBracketsFalse() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\OptionalBrackets.txt";
        OptionalCurlyBraces test = new OptionalCurlyBraces(FileConverter.readInLines(fileNameTemp));

        for (int i = 0; i < 9; i++) {
            assert (!test.checkForBrace(i));
        }
    }

    @Test
    public void checkForBracketsTrue() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\OptionalBrackets.txt";
        OptionalCurlyBraces test = new OptionalCurlyBraces(FileConverter.readInLines(fileNameTemp));

        for (int i = 11; i < 17; i++) {
            assert (test.checkForBrace(i));
        }
    }

   // @Test
    public void checkTextForBracktsTest() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\OptionalBrackets.txt";
        OptionalCurlyBraces test = new OptionalCurlyBraces(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkTextForBraces());
        errorFinder.readText();
    }
    
        @Test
    public void checkTextForBracktsTestDavid() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        OptionalCurlyBraces test = new OptionalCurlyBraces(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkTextForBraces());
        errorFinder.readText();
    }
        
}
