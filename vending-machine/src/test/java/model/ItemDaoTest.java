
package model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vending.model.Item;
import com.vending.model.ItemDaoImpl;

import static org.junit.Assert.*;

public class ItemDaoTest {
    
    public ItemDaoTest() {
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
     * Test of getItemById method, of class ItemDao.
     */
    @Test
    public void testGetItemById() {
        ItemDaoImpl items = new ItemDaoImpl();
        Item item = items.getItemById(1);
        assertTrue(item != null);
        item = items.getItemById(15);
        assertTrue(item == null);
    }

    /**
     * Test of getItems method, of class ItemDao.
     */
    @Test
    public void testGetItems() {
        ItemDaoImpl items = new ItemDaoImpl();
        List<Item> itemsList = items.getItems();
        assertTrue(itemsList.size() != 0);
    }
    
}
