package rvt;

import java.io.*;
import java.util.*;

public class ToDoListCSV {
    private ArrayList<String> todoList;
    private final String filePath = "src/main/java/rvt/todo.csv";
    private final String valueRegex= "^[A-Za-z0-9 ]{3,}$";


    public ToDoListCSV() {
        this.todoList = new ArrayList<>();
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(todoList.get(i).replace(",", " "));
        }
    }

    private void updateFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, false))) {
            pw.flush();
            pw.println("id,task");
            for (int i = 0; i < todoList.size(); i++) {
                int index = i+1;
                //pw.print(index + ",");
                pw.println(todoList.get(i));
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
                    todoList.add(line.trim());
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
        int id = getLastID() + 1;
        this.todoList.add(task);
        checkEventString(task);
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