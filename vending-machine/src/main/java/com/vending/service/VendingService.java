
package com.vending.service;

import java.math.BigDecimal;
import java.util.List;
import com.vending.model.Item;

/**
 * Vending machine service 
 * @version 1.0
 * 
 */
public interface VendingService {
    
	/**
	* addCoin method used to add one Coin at a time
	* @param coin is the key represent coin denominations value, it can be : quarter, dime, nickel, dollar ..etc
	* @return Nothing.
	* if the new balance after adding the coin exceed 1 dollar return the coin and alert the user
	*/
	public void addCoin(String coin);
    
	/**
	* purchaseItem process the user order and return extra balance 
	* if item out of stock alert the user
	* if fund is insufficient alert the user and return inserted coins by calling {@code coinsReturn} method 
	*/
	public void purchaseItem();
    
	/**
	* return any extra balance after making the order 
	*/
	public void changeReturn();
    
	/**
	* return inserted coins 
	*/
    public void coinsReturn();

    BigDecimal getBalance();

    String getAlert();

    ReturnedCoins getReturnedCoins();

    int getSelectedItem();

    Item getItemById(int id);

    List<Item> getItems();

    void setBalance(BigDecimal balance);

    void setAlert(String alert);

    void setReturnedCoins(ReturnedCoins returnedCoins);

    void setSelectedItem(int selectedItem);
    
}
