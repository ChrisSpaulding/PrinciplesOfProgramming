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
public class CaseTesting {
    
    public CaseTesting() {
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
    
    @Test
    public void testCasingIsClassNameProper(){
    
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
       Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
       assert(!casing.isClassNameProper(11));
    }
    
       @Test
    public void testConstantsUpper(){
    
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
       Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
 
       assert(!casing.isConsantCapital(15));
    }
    
    
       @Test
    public void testConstantsUpperTrue(){
    
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
       Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
       assert(casing.isConsantCapital(16));
    }

    

    @Test
    public void stringAtPosIsUpperCase(){
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
        Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
        String test= "TEST";
        assert(casing.stringAtPosIsUpperCase(2, test));
        
    }
     @Test
    public void stringAtPosIsUpperCaseFalse(){
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
        Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
        String test= "TeST";
        assert(!casing.stringAtPosIsUpperCase(0, test));
        
    }
    @Test
        public void stringAtPosIsUpperCaseFalse1(){
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
        Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
        String test= "TESt =";
        assert(!casing.stringAtPosIsUpperCase(0, test));
        
    }
        
        @Test
        public void testFindClassLine(){
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
        Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
        int test= casing.findClassLine();
        int expect=11;
        assert(test==expect);
        }
        
               @Test
    public void testLineHasMethodTrue(){
    
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
       Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
       assert(casing.checkLineForMethods(18));
    }
    
    @Test
     public void testLineHasMethodFalse(){
    
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
       Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
       assert(!casing.checkLineForMethods(17));
    }
     
   @Test
   public void testCasingTotal(){
       String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\testCaps.txt";
       Casing casing = new Casing(FileConverter.readInLines(fileNameTemp));
       casing.ensureClassCapitalization();
       ErrorFinder errorFinder= new ErrorFinder(casing.ensureClassCapitalization());
       errorFinder.readText();
   }
  
}
