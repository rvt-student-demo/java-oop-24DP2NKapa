package rvt.box;
import java.util.*;

public class MainBox {
    public static void main(String[] args) {
        Box box = new Box(10);
        Box anotherBox = new Box(5);

        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2)) ;
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));


        anotherBox.add(new CD("Toby Fox", "Megalovania", 2015));
        anotherBox.add(new CD("Toby Fox", "Another Medium", 2015));
        anotherBox.add(new CD("Toby Fox", "Spider Dance", 2015));
        anotherBox.add(new CD("Toby Fox", "Howdy!", 2015));

        box.add(anotherBox);

        System.out.println(box);
    }
}
