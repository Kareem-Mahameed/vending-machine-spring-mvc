package com.vending.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import com.vending.model.Coin;
import com.vending.model.Item;
import com.vending.model.ItemDao;

public class VendingServiceImpl implements VendingService {
    private ItemDao itemDao;
    private BigDecimal balance;
    private int selectedItem;
    private ReturnedCoins returnedCoins;
    private String alert;
    TotalCoins totalCoins;
    
    @Inject
    public VendingServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
        balance = new BigDecimal("0.00");
        selectedItem = 0;
        returnedCoins = null;
        alert = null;
        totalCoins= new TotalCoins();
    }

    @Override
    public void addCoin(String coin) {

    		BigDecimal newBalance = null;
    		Coin coinValue = null;
        switch (coin) {
        
            case "quarter":
            		coinValue=Coin.QUARTER;
            		newBalance = balance.add(new BigDecimal(coinValue.getDenomination()));                
                break;
                
            case "dime":
            		coinValue=Coin.DIME;
            		newBalance = balance.add(new BigDecimal(coinValue.getDenomination()));           		
                break;
                
            case "nickel":
            		coinValue=Coin.NICKLE;
            		newBalance = balance.add(new BigDecimal(coinValue.getDenomination()));
                break;
                
            // for future use , if machine need to accept dollars   
            case "dollar":
            		coinValue=Coin.DOLLAR;
            		newBalance = balance.add(new BigDecimal(coinValue.getDenomination()));
            		break;
            		
            case "twodollar":
        		coinValue=Coin.TWODOLLARS;
        		newBalance = balance.add(new BigDecimal(coinValue.getDenomination()));           		
                break;
                
            default:
        }
        if (newBalance.compareTo(new BigDecimal(1)) <= 0) // check if the new balance don't exceed 1 Dollar 
        {
        		balance=newBalance;
        		totalCoins.add(coinValue);
        		alert=null;
        		returnedCoins=null;
        }
        else {
        	alert="Vending Machine can take up to 1 Dollar in a time";
        	returnedCoins= new ReturnedCoins(new BigDecimal(coinValue.getDenomination()));
        }
       
    }
    @Override
    public void purchaseItem() {
        if (selectedItem != 0) {
            Item item = itemDao.getItemById(selectedItem);
            if (item!=null) {
            	
            
            BigDecimal selectedItemPrice = item.getPrice();
            if (item.getQuantity() <= 0) {
                alert = "the Item sold out, please choose other item or return inserted coins";
            } else if (balance.compareTo(selectedItemPrice) < 0) {
                BigDecimal difference = selectedItemPrice.subtract(balance);
                coinsReturn();
                alert = "Insufficient fund, Please try again and add: $" + difference;
            } else {
                BigDecimal newBalance = balance.subtract(selectedItemPrice);
                ReturnedCoins extraCoins = new ReturnedCoins(newBalance);
                returnedCoins = extraCoins;
                balance = new BigDecimal("0.00");
                int newItemQuantity = item.getQuantity() - 1;
                item.setQuantity(newItemQuantity);
                alert = "Collect your Item("+item.getName()+"), Thank You";
                totalCoins.clear();
            }
            	}
            else {
            	alert="Invalid selection, please try again";
            	returnedCoins=null;
            	selectedItem = 0;
            }
   
        }
        else {
        	alert="Please Choose Item";
        	returnedCoins=null;
        }
    }
    @Override
    public void changeReturn() {
    		ReturnedCoins extraCoins = new ReturnedCoins(balance);
    		returnedCoins = extraCoins;
        balance = new BigDecimal("0.00");
        selectedItem = 0;
        alert = null;
    }    
    @Override
    public void coinsReturn() {
    	ReturnedCoins extraCoins = new ReturnedCoins(totalCoins.getQuantity(Coin.QUARTER),totalCoins.getQuantity(Coin.DIME),totalCoins.getQuantity(Coin.NICKLE),totalCoins.getQuantity(Coin.PENNIES));
    	totalCoins.clear();
        returnedCoins = extraCoins;
        balance = new BigDecimal("0.00");
        selectedItem = 0;
        alert = null;
    }
    
    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }
    @Override
    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    @Override
    public int getSelectedItem() {
        return selectedItem;
    }
    @Override
    public void setSelectedItem(int SelectedItem) {
        this.selectedItem = SelectedItem;
    }
    @Override
    public ReturnedCoins getReturnedCoins() {
        return returnedCoins;
    }
    @Override
    public void setReturnedCoins(ReturnedCoins returnedCoins) {
        this.returnedCoins = returnedCoins;
    }      
    @Override
    public String getAlert() {
        return alert;
    }
    @Override
    public void setAlert(String alert) {
        this.alert = alert;
    }    
}
