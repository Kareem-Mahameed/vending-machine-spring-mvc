/*
 * pennies added for future use in case we we started selling items  with price not multiples of 5 pennies, 
 * and extra pennies less than 5 will can go for donation 
 * once we vending machine support denominations like dollar or higher, constructor should be changed to support these coinss
 */
package com.vending.service;

import java.math.BigDecimal;

public class ReturnedCoins {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies; 
    
    // this constructor to return the coins if user choose to return the coins before making any order 
    public ReturnedCoins(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }
    // this constructor to return the extra money after making order
    public ReturnedCoins(BigDecimal balance) {
        pennies = Integer.parseInt(balance.toString().replace(".", ""));
        quarters = pennies / 25;
        pennies %= 25;
        dimes = pennies / 10;
        pennies %= 10;
        nickels = pennies / 5;
        pennies %= 5;
    }
    

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }
    
}
