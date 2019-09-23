package com.vending.service;

import java.util.HashMap;
import java.util.Map;

import com.vending.model.Coin;

/**
 * Coins supported by Vending Machine.
 * coins denomination represented as {@code enum}
 * we added support for penny and dollars and it can support any coin denominations easily
 * @author Kareem
 */
public class TotalCoins {
	private Map<Coin, Integer> totalCoins = new HashMap<Coin, Integer>();
	
	public int getQuantity(Coin coin){
		Integer value = totalCoins.get(coin); 
		return value == null? 0 : value ; 
		} 
	
	public void add(Coin coin){ 
		if (hasItem(coin)) {
		int count = totalCoins.get(coin); 
		totalCoins.put(coin, count+1); 
		}
		else
		{
			put( coin, 1);
		}
		}
	
	public void deduct(Coin coin) {
		if (hasItem(coin)) {
			int count = totalCoins.get(coin); 
			totalCoins.put(coin, count - 1); 
			} 
		} 
	
	public boolean hasItem(Coin coin){ 
		return getQuantity(coin) > 0;
		}
	
	public void clear(){ 
		totalCoins.clear(); 
		} 
	
	public void put(Coin coin, int quantity) {
		totalCoins.put(coin, quantity); 
		}

}



