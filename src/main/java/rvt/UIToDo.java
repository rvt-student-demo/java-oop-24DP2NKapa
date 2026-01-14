package rvt;

import java.util.*;

public class UIToDo {
    private ToDoList list;
    private Scanner scanner;

    public UIToDo(ToDoList theList, Scanner theScanner) {
        list = theList;
        scanner = theScanner;
    }

    public void start() {
        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                list.print();
                continue;
            } else if (command.equals("add")) {
                System.out.print("To add: ");
                String item = scanner.nextLine();
                list.add(item);
                continue;
            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int item = Integer.valueOf(scanner.nextLine());
                list.remove(item);
                continue;
            }
        }
    }
}
