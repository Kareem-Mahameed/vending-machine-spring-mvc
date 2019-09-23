package com.vending.model;

/**
 * Coins supported by Vending Machine.
 * coins denomination represented as {@code enum}
 * we added support for penny and dollars and it can support any coin denominations easily
 * @author Kareem
 */
public enum Coin { 
	PENNIES("0.01"), 
	NICKLE("0.05"), 
	DIME("0.10"), 
	QUARTER("0.25"), 
	DOLLAR("1.00"), 
	TWODOLLARS("2.00"); 
	// any new coin denomination can be added here
private String denomination; 
private Coin(String denomination){
	this.denomination = denomination; 
	} 
public String getDenomination(){ 
	return denomination; 
	} 
}
