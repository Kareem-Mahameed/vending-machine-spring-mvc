package service;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vending.model.Coin;
import com.vending.service.TotalCoins;

public class TotalCoinsTest {
    
    public TotalCoinsTest() {
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
     * Test of  of class TotalCoins.
     */
    @Test
    public void testTotalCoins() {
    		TotalCoins totalCoins = new TotalCoins();
    		assertEquals("quarters availability does not match correct result", false, totalCoins.hasItem(Coin.QUARTER));
    		assertEquals("dimmes numbers does not match correct result", 0, totalCoins.getQuantity(Coin.DIME));
    		
    		totalCoins.add(Coin.NICKLE);
    		assertEquals(" nickles does not match correct result", 1, totalCoins.getQuantity(Coin.NICKLE));
    		
    		totalCoins.add(Coin.NICKLE);
    		totalCoins.add(Coin.NICKLE);
    		assertEquals(" nickles does not match correct result", 3, totalCoins.getQuantity(Coin.NICKLE));
    		
    		totalCoins.deduct(Coin.NICKLE);
    		totalCoins.deduct(Coin.NICKLE);
    		assertEquals(" nickles does not match correct result", 1, totalCoins.getQuantity(Coin.NICKLE));
    		
    		totalCoins.deduct(Coin.NICKLE);
    		totalCoins.clear();
    		assertEquals(" nickles does not match correct result", 0, totalCoins.getQuantity(Coin.NICKLE));
    	
        
    } 
}
