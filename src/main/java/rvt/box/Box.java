package rvt.box;
import java.util.*;

public class Box {
    private int capacity;
    private ArrayList<Packable> contents;

    public Box (int capacity) {
        this.capacity = capacity;
    }

    public void add (Packable item) {
        contents.add(item);
    }

    public String toString() {
        return "Box: " + contents.size() + " items";
    }
}
