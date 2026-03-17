package rvt.onlineshop;

import java.util.*;

public class Warehouse {
    // stores prouct name and its PRICE
    Map<String, Integer> warehousePrices = new HashMap<>();
    // stores prouct name and its STOCK
    Map<String, Integer> warehouseStock = new HashMap<>();

    public void addProduct(String product, int price, int stock) {
        // adds the product both to the PRICES and STOCK hashmaps
        warehousePrices.put(product, price);
        warehouseStock.put(product, stock);
    }

    public int price(String product) {
        if (warehousePrices.containsKey(product)) {
            //gets the PRICE of a product if the product exists
            return warehousePrices.get(product);
        } else {
            //no product = return -99
            return -99;
        }
    }

    public int stock(String product) {
        if (warehouseStock.containsKey(product)) {
            // gets the STOCK of a product if the product exists
            return warehouseStock.get(product);
        } else {
            // no product = return 0
            return 0;
        }
    }

    public boolean take(String product) {
        /**
         * checks if taking a product is possible
         * First by checking if the product exists at all
         * Then by checking its quantity
         */
        if (warehouseStock.containsKey(product)) {
            if (warehouseStock.get(product) > 0) {
                warehouseStock.put(product, warehouseStock.get(product) - 1);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Set<String> products() {
        return warehouseStock.keySet();
    }
}
