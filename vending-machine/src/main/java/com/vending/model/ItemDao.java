
package com.vending.model;

import java.util.List;

public interface ItemDao {
    public Item getItemById(int id);
    public List<Item> getItems();
    // below operation can be used to load and delete items  
    public void updateItemQuantity(int itemId,int newQuantity);
    public void addItem(Item item);
    public void deleteItem(Item item);
}
