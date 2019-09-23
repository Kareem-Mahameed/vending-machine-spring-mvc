package com.vending.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class ItemDaoMockImpl extends ItemDaoImpl{
        public ItemDaoMockImpl() {
        items = new HashMap<>();
        // vending machine should be able to sell any type of items not only 3 items
        // for unit testing we add more items and to simulate all cases  
        items.put(1, new Item(1,"Item-1",new BigDecimal("0.55"),1));
        items.put(2, new Item(2,"Item-2",new BigDecimal("0.70"),9));
        items.put(3, new Item(3,"Item-3",new BigDecimal("0.75"),2));
        items.put(4, new Item(4,"Item-4",new BigDecimal("1.85"),5));
        items.put(5, new Item(5,"Item-5",new BigDecimal("1.25"),4));
        items.put(6, new Item(6,"Item-6",new BigDecimal("1.95"),0));
        items.put(7, new Item(7,"Item-7",new BigDecimal("1.75"),3));
        items.put(8, new Item(8,"Item-8",new BigDecimal("1.85"),11));
        items.put(9, new Item(9,"Item-9",new BigDecimal("1.95"),1));        
    }
}
