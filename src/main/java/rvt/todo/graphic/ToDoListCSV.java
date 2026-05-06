package rvt.todo.graphic;

import java.io.*;
import java.util.*;

public class ToDoListCSV {
    private ArrayList<String> todoList;
    private final String filePath = "src/main/java/rvt/todo/graphic/todo.csv";
    private final String valueRegex= "^[A-Za-z0-9 ]{3,}";


    public ToDoListCSV() {
        this.todoList = new ArrayList<>();
        loadFromFile();
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(todoList.get(i).replace(",", " "));
        }
    }

    public ArrayList<String> getAll() {
        return new ArrayList<>(todoList);
    }

    private void updateFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, false))) {
            pw.flush();
            pw.println("id,task");
            for (int i = 0; i < todoList.size(); i++) {
                pw.println((i + 1) + "," + todoList.get(i));
            }
        }
        catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void remove(int index) {
        todoList.remove(index - 1);
        updateFile();
    }

    public void loadFromFile() {
        String line;
        boolean isHeader = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                if (!line.trim().isEmpty()) {
                    String[] parts = line.trim().split(",", 2); // split into max 2 parts
                    if (parts.length == 2) {
                        todoList.add(parts[1]); // store only the task part
                    }
                }
            }
            br.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    public int getLastID() {
        return todoList.size();        
    }
    
    public void add(String task) throws Exception {
        checkEventString(task);
        int id = getLastID() + 1;
        this.todoList.add(task);
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
            pw.println(id + "," + task);
        }
        catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public boolean checkEventString(String value) throws Exception {
        if (value.matches(valueRegex)) {
            return true;
        } else {
            throw new Exception("Invalid format. Enter a normal task."); 
        }
    }
}