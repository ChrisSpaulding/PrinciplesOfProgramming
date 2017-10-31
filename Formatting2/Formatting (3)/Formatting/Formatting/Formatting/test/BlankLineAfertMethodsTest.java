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
public class BlankLineAfertMethodsTest {
    
    public BlankLineAfertMethodsTest() {
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
    public void checkForMethodSpacing() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        MethodSpacing test = new MethodSpacing(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkForNeededBlankLines());
        errorFinder.readText();
    }
        
    
                @Test
    public void checkForMethodSpacingClassHeader() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        MethodSpacing test = new MethodSpacing(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkSpaceAfterClassHeader());
        errorFinder.readText();
    }
    
    @Test
    public void checkForMethodSpacingAfterMethods() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        MethodSpacing test = new MethodSpacing(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkSpaceAfterMethods());
        errorFinder.readText();
    }
    
          //      @Test
    public void checkForMethodSpacingAfterDeclarations() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        MethodSpacing test = new MethodSpacing(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkSpaceAfterDeclarations());
        errorFinder.readText();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
