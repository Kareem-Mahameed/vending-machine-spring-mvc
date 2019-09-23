
package service;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vending.service.ReturnedCoins;

public class ReturnedCoinsTest {
    
    public ReturnedCoinsTest() {
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

    /**
     * Test of get Quarters,Nickels, Dimes, Pennies  method, of class ReturnedCoins.
     */
    @Test
    public void testReturnedCoinsCalculations() {
    		ReturnedCoins returnedCoins = new ReturnedCoins(new BigDecimal("3.19"));
        assertEquals("quarters numbers does not match correct result", 12, returnedCoins.getQuarters());
        assertEquals("dimes numbers does not match correct result.", 1, returnedCoins.getDimes());
        assertEquals("nickels numbers does not match correct result.", 1, returnedCoins.getNickels());
        assertEquals("pennies numbers does not match correct result.", 4, returnedCoins.getPennies());
        
        returnedCoins = new ReturnedCoins(12,1,1,4);
        assertEquals("quarters numbers does not match correct result", 12, returnedCoins.getQuarters());
        assertEquals("dimes numbers does not match correct result.", 1, returnedCoins.getDimes());
        assertEquals("nickels numbers does not match correct result.", 1, returnedCoins.getNickels());
        assertEquals("pennies numbers does not match correct result.", 4, returnedCoins.getPennies());
        
    } 
}
