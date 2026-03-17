package rvt.onlineshop;

import java.util.Scanner;

public class MainShop {
    public static void main(String[] args) {
    Warehouse warehouse = new Warehouse(); // create a warehouse

    // add assortiment
    warehouse.addProduct("coffee", 5, 10);
    warehouse.addProduct("milk", 3, 20);
    warehouse.addProduct("cream", 2, 55);
    warehouse.addProduct("bread", 7, 8);

    Scanner scanner = new Scanner(System.in);

    Store store = new Store(warehouse, scanner);
    store.shop("John"); // start UI and add placeholder name
    }
}
