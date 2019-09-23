package service;

import java.math.BigDecimal;
import com.vending.model.Item;
import com.vending.model.ItemDao;
import com.vending.model.ItemDaoMockImpl;
import com.vending.service.ReturnedCoins;
import com.vending.service.VendingService;
import com.vending.service.VendingServiceImpl;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingServiceTest {
    
    public VendingServiceTest() {
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
     * Test of addCoin method, of class VendingServiceImpl.
     */
    @Test
    public void testAddCoins() {
        ItemDao dao = new ItemDaoMockImpl();
        VendingService vendingService = new VendingServiceImpl(dao);      
        vendingService.setBalance(new BigDecimal("0.00"));
        vendingService.addCoin("quarter");
        assertEquals(vendingService.getBalance(), new BigDecimal("0.25"));
        vendingService.setBalance(new BigDecimal("0.00"));
        vendingService.addCoin("dime");
        assertEquals(vendingService.getBalance(), new BigDecimal("0.10"));
        vendingService.setBalance(new BigDecimal("0.00"));
        vendingService.addCoin("nickel");
        assertEquals(vendingService.getBalance(), new BigDecimal("0.05"));
        
        // test adding to reach more than dollar
        vendingService.setBalance(new BigDecimal("0.00"));
        vendingService.addCoin("quarter");
        vendingService.addCoin("quarter");
        vendingService.addCoin("quarter");
        vendingService.addCoin("dime");
        vendingService.addCoin("dime");
        assertEquals(vendingService.getBalance(), new BigDecimal("0.95"));
        // adding more 1 dime and confirm that balance still 0.95
        vendingService.addCoin("dime");
        assertEquals(vendingService.getBalance(), new BigDecimal("0.95"));
        
        // for further enhancement of the machine to support dollar and 2 dollars
        vendingService.setBalance(new BigDecimal("0.00"));
        vendingService.addCoin("dollar");
        assertEquals(vendingService.getBalance(), new BigDecimal("1.00"));
    }
    
    /**
     * Test of makeSelection method, of class VendingServiceImpl.
     */
    @Test
    public void testMakeSelection() {
        ItemDao dao = new ItemDaoMockImpl();
        VendingService vendingService = new VendingServiceImpl(dao);
        vendingService.purchaseItem();
        assertEquals("Please Choose Item alert does not match expected result.", vendingService.getAlert(), "Please Choose Item");

        vendingService.setSelectedItem(100);
        vendingService.purchaseItem();
        assertEquals("invalid selection alert does not match expected result.", vendingService.getAlert(), "Invalid selection, please try again");

        vendingService.setSelectedItem(6);
        vendingService.purchaseItem();
        assertEquals("Item sold out: alert does not match expected result.", vendingService.getAlert(), "the Item sold out, please choose other item or return inserted coins");
        
        vendingService.setSelectedItem(3);
        vendingService.setBalance(new BigDecimal("0.15"));
        vendingService.purchaseItem();
        assertEquals("Insufficient funds: alert does not match expected result.", vendingService.getAlert(), "Insufficient fund, Please try again and add: $0.60");
        
        Item item = dao.getItemById(3);
        int startingQty = item.getQuantity();
        vendingService.setSelectedItem(3);
        vendingService.setBalance(new BigDecimal("1.94"));
        vendingService.purchaseItem();
        assertEquals("Successful purchase: balance does not match expected result.", vendingService.getBalance(), new BigDecimal("0.00"));
        assertEquals("Successful purchase: alert does not match expected result.", vendingService.getAlert(), "Collect your Item(Item-3), Thank You");
        assertEquals("Successful purchase: item quantity not decremeting.", startingQty - 1, item.getQuantity());
        ReturnedCoins returnedCoins = vendingService.getReturnedCoins();
        assertEquals("Successful purchase: change quarters do not match expected quantity.", 4, returnedCoins.getQuarters());
        assertEquals("Successful purchase: change dimes do not match expected quantity.", 1, returnedCoins.getDimes());
        assertEquals("Successful purchase: change nickels do not match expected quantity.", 1, returnedCoins.getNickels());
        assertEquals("Successful purchase: change pennies do not match expected quantity.", 4, returnedCoins.getPennies());
    }
    
    /**
     * Test of changeReturn method, of class VendingServiceImpl.
     */
    @Test
    public void testChangeReturn() { 
        ItemDao dao = new ItemDaoMockImpl();
        VendingService vendingService = new VendingServiceImpl(dao);
        vendingService.setSelectedItem(4);
        vendingService.setAlert("test alert");
        vendingService.setBalance(new BigDecimal("2.43"));
        vendingService.changeReturn();
        assertEquals("Balance not reset to 0.00", new BigDecimal("0.00"), vendingService.getBalance());
        assertEquals("SelectedItem number not reset to 0", 0, vendingService.getSelectedItem());
        assertEquals("Alert not reset to null.", null, vendingService.getAlert());
        ReturnedCoins returnedCoins = vendingService.getReturnedCoins();
        assertEquals("Quarters do not match expected quantity.", 9, returnedCoins.getQuarters());
        assertEquals("Dimes do not match expected quantity.", 1, returnedCoins.getDimes());
        assertEquals("Nickels do not match expected quantity.", 1, returnedCoins.getNickels());
        assertEquals("Pennies do not match expected quantity.", 3, returnedCoins.getPennies());        
    }
    
    /**
     * Test of coinsReturn method, of class VendingServiceImpl.
     */
    @Test
    public void testCoinReturn() {
        ItemDao dao = new ItemDaoMockImpl();
        VendingService vendingService = new VendingServiceImpl(dao);
        vendingService.setSelectedItem(4);
        vendingService.setAlert("test alert");
        vendingService.addCoin("quarter");
        vendingService.addCoin("nickel");
        vendingService.addCoin("nickel");
        vendingService.addCoin("nickel");
        vendingService.addCoin("nickel");
        vendingService.coinsReturn();
        assertEquals("Balance not reset to 0.00", new BigDecimal("0.00"), vendingService.getBalance());
        assertEquals("SelectedItem number not reset to 0", 0, vendingService.getSelectedItem());
        assertEquals("Alert not reset to null.", null, vendingService.getAlert());
        ReturnedCoins returnedCoins = vendingService.getReturnedCoins();
        assertEquals("Quarters do not match expected quantity.", 1, returnedCoins.getQuarters());
        assertEquals("Dimes do not match expected quantity.", 0, returnedCoins.getDimes());
        assertEquals("Nickels do not match expected quantity.", 4, returnedCoins.getNickels());
        assertEquals("Pennies do not match expected quantity.", 0, returnedCoins.getPennies());        
    }
    
}
