

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
public class AlphaTest {
    
    public AlphaTest() {
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
    public void checkforMethodsListDavid() {

        String fileNameTemp = "C:\\Users\\Spaulding\\Documents\\school\\Formatting\\Formatting\\Formatting\\src\\Formatting\\test1.txt";
        AlphabeticalOrder test = new AlphabeticalOrder(FileConverter.readInLines(fileNameTemp));
        ErrorFinder errorFinder= new ErrorFinder(test.checkAlphaOrderMethods());
        errorFinder.readText();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
