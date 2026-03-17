package rvt.box;
import java.util.*;

public class Box implements Packable {
    private double weight;
    private double inside;
    private double capacity;
    private ArrayList<Packable> contents = new ArrayList<Packable>();

    public Box (int capacity) {
        this.capacity = capacity;
        this.weight = 0;
        this.inside = 0; 
    }

    public void add (Packable item) {
        if (capacity > inside) {
            double test = inside + item.weight();
            if (test <= capacity) {
                contents.add(item);
                inside += item.weight();                
            } else {
                System.out.println("Not enough space! Box will go kaboom!");
            }
        } else {
            System.out.println("Not enough space! Box will go kaboom!");
        }
    }

    public double weight() {
        return this.weight;
    }

    public String toString() {
        return "Box: " + contents.size() + " items";
    }
}
