package rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ToDoListCSV {
    private ArrayList<String> todoList;
    private final String filePath = "";

    public ToDoListCSV() {
        this.todoList = new ArrayList<>();
    }

    public void add(String item) {
        todoList.add(item);
    }

    public void print() {
        
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(todoList.get(i).replace(",", " "));
        }
    }

    public void remove(int index) {
        todoList.remove(index - 1);
    }

    public void loadFromFile() {
        String line;
        boolean isHeader = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/rvt/todo.csv"));
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                if (!line.trim().isEmpty()) {
                    todoList.add(line.trim());
                }
            }
            br.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    /*private int getLastID() {
        return 0;        
    }*/   
}