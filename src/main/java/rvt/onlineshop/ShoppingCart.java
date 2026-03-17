package rvt.onlineshop;

import java.util.*;

public class ShoppingCart {
    int cartprice = 0;
    Map<String, Item> cartMap = new HashMap<>();

    public void add(String product, int price) {
        if (cartMap.containsKey(product)) {
            cartMap.get(product).increaseQuantity(); // addresses the VALUE of datatype Item and uses its method    
        } else { //if the item is new
            Item item = new Item(product, 1, price);
            cartMap.put(product, item);
        }
        // always increase price
        cartprice += price;  
    }

    public int price() {
        //get the price of the CART exactly
        return cartprice;
    }

    public void print() {
        Collection<Item> values = cartMap.values(); //get values using the method .values()
        // formatting the values - convert it to string and get a pretty print
        String formatted = values.toString().replace("[", "").replace("]", "").replace(",", "\n");
        System.out.println(formatted);
    }
}
