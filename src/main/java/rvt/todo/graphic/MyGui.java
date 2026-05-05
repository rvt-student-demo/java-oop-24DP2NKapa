package rvt.todo.graphic;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class MyGui {
    static ToDoListCSV todo = new ToDoListCSV();

    public static void main(String[] args) {
        todo.loadFromFile(); // Ieladēt saglabātus task sākumā
        JFrame frame = new JFrame("ToDo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null); // ļoti svarīgi!
        // TextArea attēlošanai
        JTextArea tasks = new JTextArea("Spiež 'drukāt uzdevumus' lai paradīt uzdevumus");
        tasks.setBounds(300, 50, 550, 340);
        tasks.setEditable(false);
        tasks.setFont(new Font("Serif", Font.PLAIN, 18));
        tasks.setLineWrap(true);
        // Buttons
        JButton buttonAdd    = new JButton("Pievienot uzdevumu");
        JButton buttonRemove = new JButton("Dzēst uzdevumu");
        JButton buttonList   = new JButton("Drukāt uzdevumus");
        JButton buttonExit   = new JButton("Iziet no lietotnes");

        buttonAdd.setBounds(50, 50, 200, 40);
        buttonRemove.setBounds(50, 150, 200, 40);
        buttonList.setBounds(50, 250, 200, 40);
        buttonExit.setBounds(50, 350, 200, 40);

        // Helper: refresh the text area with current tasks
        Runnable refreshList = () -> {
            StringBuilder sb = new StringBuilder();
            // ToDoListCSV.print() goes to console, so we build display string here
            // We expose task count via getLastID() and rely on print() for console;
            // for the GUI we rebuild from the CSV by reloading — simplest approach
            // that requires no extra getter. Instead, capture System.out:
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream old = System.out;
            System.setOut(new java.io.PrintStream(baos));
            todo.print();
            System.setOut(old);
            String output = baos.toString();
            tasks.setText(output.isEmpty() ? "(no tasks)" : output);
        };

        // Add
        buttonAdd.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter task name:", "Add a task", JOptionPane.PLAIN_MESSAGE);
            if (input == null) return; // user cancelled
            try {
                todo.add(input.trim());
                refreshList.run();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Remove
        buttonRemove.addActionListener(e -> {
            int count = todo.getLastID();
            if (count == 0) {
                JOptionPane.showMessageDialog(frame, "No tasks to remove.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String input = JOptionPane.showInputDialog(frame,
                "Enter task number to remove (1–" + count + "):", "Remove a task", JOptionPane.PLAIN_MESSAGE);
            if (input == null) return;
            try {
                int index = Integer.parseInt(input.trim());
                if (index < 1 || index > count) throw new NumberFormatException();
                todo.remove(index);
                refreshList.run();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        });

        // List
        buttonList.addActionListener(e -> refreshList.run());
        // Exit
        buttonExit.addActionListener(e -> System.exit(0));
        panel.add(buttonAdd);
        panel.add(buttonRemove);
        panel.add(buttonList);
        panel.add(buttonExit);
        panel.add(tasks);
        frame.add(panel);
        frame.setSize(900, 480);
        frame.setVisible(true);
    }
}