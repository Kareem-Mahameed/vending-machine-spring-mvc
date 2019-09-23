/*
 * you can add any item type to the machine with any price and any inventory count,  and  machine will support it
 */
package com.vending.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    HashMap<Integer,Item> items;
    
    public ItemDaoImpl() {
        items = new HashMap<>();
        items.put(1, new Item(1,"Item 1",new BigDecimal("0.55"),10));
        items.put(2, new Item(2,"Item 2",new BigDecimal("0.70"),10));
        items.put(3, new Item(3,"Item 3",new BigDecimal("0.75"),10));
        /*
        items.put(4, new Item(4,"Item-4",new BigDecimal("1.85"),5));
        items.put(5, new Item(5,"Item-5",new BigDecimal("1.25"),4));
        items.put(6, new Item(6,"Item-6",new BigDecimal("1.95"),0));
        items.put(7, new Item(7,"Item-7",new BigDecimal("1.75"),3));
        items.put(8, new Item(8,"Item-8",new BigDecimal("1.85"),11));
        items.put(9, new Item(9,"Item-9",new BigDecimal("1.95"),1));        
         */
      
    }

    @Override
    public Item getItemById(int id) {
        return items.get(id);
    }

    @Override
    public List<Item> getItems() {
        return new ArrayList<>(items.values());
    }

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Item item) {
		// TODO Auto-generated method stub
		
	}
/**
 * this operation can be used to add new quantity to the vending machine while its working 
 */
	@Override
	public void updateItemQuantity(int itemId, int newQuantity) {
		Item item=getItemById(itemId);
		item.setQuantity(newQuantity);
		
	}
    
}
