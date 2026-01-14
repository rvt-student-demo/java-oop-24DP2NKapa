package rvt;

import java.util.*;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        UIToDo UI = new UIToDo(list, scanner);
        UI.start();
    }
}
