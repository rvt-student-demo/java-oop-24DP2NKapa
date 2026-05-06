package rvt.todo.graphic;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Font;

public class MyGui {
	static ToDoListCSV todo = new ToDoListCSV();

	public static void logAction() {
		System.out.println("Action performed!");
	}

	public static void formatArrayAndListTasks(ArrayList<String> array, JTextArea textArea) {
		textArea.setText("");
		for (int i = 0; i < array.size(); i++) {
			String str = array.get(i);
			str = str.replace(String.valueOf(','), " ");
			textArea.append((i + 1) + ": " + str + "\n");
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("ToDo List UI"); // the frame, "the skeleton"
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // panel contains everything
		JPanel panel = new JPanel();
		panel.setLayout(null); // This does some NECESSARY magic for layout
		// setup JTextArea for printing info
		JTextArea textArea = new JTextArea("");
		textArea.setBounds(300, 50, 550, 340);
		textArea.setEditable(false); // Prevents user from typing in it
		textArea.setFont(new Font("Serif", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		// intialize the buttons
		JButton buttonAdd = new JButton("Add a task");
		JButton buttonRemove = new JButton("Remove a task");
		JButton buttonList = new JButton("List the tasks");
		JButton buttonExit = new JButton("Exit the app");
		// give buttons sizes and colors
		buttonAdd.setBounds(50, 50, 200, 40); // x, y, width, height and so on
		buttonRemove.setBounds(50, 150, 200, 40);
		buttonList.setBounds(50, 250, 200, 40);
		buttonExit.setBounds(50, 350, 200, 40);

		// create event listeners
		buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logAction();
				try {
                    String task = JOptionPane.showInputDialog("Enter a task: ");
                    todo.add(task);
                    JOptionPane.showMessageDialog(null, "Task added succesfully!", "Informācija", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
		buttonRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logAction();
				String window = JOptionPane.showInputDialog("Enter index of the task to be removed (TYPE IN A VALID INTEGER!):");
				int index = Integer.valueOf(window);
				todo.remove(index);
            }
        });
		buttonList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logAction();
				ArrayList<String> intermed = new ArrayList<>();
				intermed.addAll(todo.getAll());
				formatArrayAndListTasks(intermed, textArea);
            }
        });
		buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logAction();
				System.exit(0);
            }
        });

		// add the buttons and everything to the panel element to actually show them. Like in p5.js
		panel.add(buttonAdd);
		panel.add(buttonRemove);
		panel.add(buttonList);
		panel.add(buttonExit);
		panel.add(textArea);
		// add PANEL to FRAME
		frame.add(panel);
		// set size and make visible
		frame.setSize(900, 480);	
		frame.setVisible(true);
	}
}